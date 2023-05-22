package com.qinweizhao.basic.ftp.util;

import com.qinweizhao.basic.ftp.model.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.ftpserver.ftplet.FtpException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;


/**
 * @author qinweizhao
 * @since 2023-05-22
 */
public class FtpUtil {

	private FtpUtil(){}

	private static FTPClient ftp;


	/**
	 * FTP
	 * @return FTP
	 * @throws FtpException FtpException
	 */
	public static FTP getFtp() throws FtpException{
		try {
			FTP ftp = new FTP();
			OutputUtil.SystemOutput("设置FTP连接···");
			ftp.setIpAddr(GetParam.ftpIpAddr);
			ftp.setPort(Integer.valueOf(GetParam.ftpPort));
			ftp.setUserName(GetParam.ftpUserName);
			ftp.setPwd(GetParam.ftpPassWord);
			//连接ftp服务器
			if(FtpUtil.connectFtp(ftp)){
				OutputUtil.SystemOutput("FTP连接成功···");
				return ftp;
			}else{
				throw new FtpException("FTP连接失败···",null);
			}
		} catch (Exception e) {
			throw new FtpException("FTP连接异常！！！",e);
		}
	}

	/**
	 * 获取ftp连接
	 * 
	 * @param f
	 * @return
	 * @throws IOException 
	 * @throws SocketException 
	 * @throws Exception
	 */
	public static boolean connectFtp(FTP f) throws SocketException, IOException{
		ftp = new FTPClient();
		boolean flag = false;
		int reply;
		if (f.getPort() == null) {
			ftp.connect(f.getIpAddr(), 21);
		} else {
			ftp.connect(f.getIpAddr(), f.getPort());
		}
		ftp.login(f.getUserName(), f.getPwd());
		ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
		ftp.enterLocalPassiveMode();
		reply = ftp.getReplyCode();
		if (!FTPReply.isPositiveCompletion(reply)) {
			ftp.disconnect();
			return flag;
		}
		ftp.changeWorkingDirectory(f.getPath());
		flag = true;
		return flag;
	}

	/**
	 * 关闭ftp连接
	 */
	public static void closeFtp() {
		if (ftp != null && ftp.isConnected()) {
			try {
				ftp.logout();
				ftp.disconnect();
				OutputUtil.SystemOutput("已关闭FTP连接！");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ftp上传文件
	 * 
	 * @param f
	 * @throws IOException 
	 * @throws Exception
	 */
	public static void upload(String folderName,File file, String fileName) throws FtpException{
		FileInputStream input = null;
		try {
//			ftp.setFileTransferMode(ftp.BINARY_FILE_TYPE);// 设置上传文件的类型为二进制类型
			createMultiDirectory(folderName);
			ftp.makeDirectory(folderName);
			ftp.changeWorkingDirectory(folderName);
			input = new FileInputStream(file);
			ftp.enterLocalPassiveMode();        //这个设置允许被动连接--访问远程ftp时需要
			ftp.storeFile(fileName, input);
			OutputUtil.SystemOutput("上传本地图片["+file.getAbsolutePath()+"]成功！！！"+"\r\n");
			OutputUtil.SystemOutput("远程图片地址["+folderName+"/"+fileName+"]");
		} catch (IOException e) {
			OutputUtil.SystemOutput("上传本地图片["+file.getAbsolutePath()+"]失败！！！"+"\r\n");
			e.printStackTrace();
			throw new FtpException("上传失败",e);
		} finally {
			if(input != null){
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
					OutputUtil.SystemOutput("上传错误关闭流异常");
				}
			}
		}
	}

	//  然后再利用ftpclient的makeDirectory方法创建文件夹
	public static void createDir(String remote) throws UnsupportedEncodingException, IOException {
		System.out.println("***********remote********"+remote);
		String directory = remote.substring(0, remote.lastIndexOf(File.separator) + 1);
		if (!directory.equalsIgnoreCase(File.separator)
				&& !ftp.changeWorkingDirectory(new String(directory.getBytes("GBK"), "iso-8859-1"))) {
			//  如果远程目录不存在，则递归创建远程服务器目录
			int start = 0;
			int end = 0;
			if (directory.startsWith(File.separator)) {
				start = 1;
			} else {
				start = 0;
			}
			end = directory.indexOf(File.separator, start);
			while (true) {
				String subDirectory = new String(remote.substring(start, end).getBytes("GBK"), "iso-8859-1");
				if (!ftp.changeWorkingDirectory(subDirectory)) {
					if (ftp.makeDirectory(subDirectory)) {
						System.out.println("创建目录："+subDirectory+"成功");
						ftp.changeWorkingDirectory(subDirectory);
					} else {
						OutputUtil.SystemOutput("创建目录失败");
					}
				}
				start = end + 1;
				end = directory.indexOf(File.separator, start);
				//  检查所有目录是否创建完毕
				if (end <= start) {
					break;
				}
			}
		}
	}

	private static boolean createMultiDirectory(String multiDirectory) throws IOException {
		boolean bool = false;
		String[] dirs = multiDirectory.split("/");
		ftp.changeWorkingDirectory("/");
		//按顺序检查目录是否存在，不存在则创建目录
		for(int i=1; dirs!=null&&i<dirs.length; i++) {
			if(!ftp.changeWorkingDirectory(dirs[i])) {
				if(ftp.makeDirectory(dirs[i])) {
					if(!ftp.changeWorkingDirectory(dirs[i])) {
						bool = false;
					}
				}else {
					bool = false;						
				}
			}
		}
		return bool;
	}
}
