package com.qinweizhao.basic.ftp.model;

/**
 * FTP连接常量
 * 
 */
public class FTP {

	private String ipAddr;		// FTP服务器ip地址
	private Integer port;		// 端口号
	private String userName;	// 用户名
	private String pwd;			// 密码
	private String path;		// 上传文件的路径名称
	private String fileName;	// 上传文件重新命名

	public FTP() {
		super();
	}

	public FTP(String ipAddr, Integer port, String userName, String pwd,
			String path, String fileName) {
		super();
		this.ipAddr = ipAddr;
		this.port = port;
		this.userName = userName;
		this.pwd = pwd;
		this.path = path;
		this.fileName = fileName;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "FTP [ipAddr=" + ipAddr + ", port=" + port + ", userName="
				+ userName + ", pwd=" + pwd + ", path=" + path + "]";
	}

}
