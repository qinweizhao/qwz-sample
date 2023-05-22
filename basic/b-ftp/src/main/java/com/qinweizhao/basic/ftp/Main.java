package com.qinweizhao.basic.ftp;

import com.qinweizhao.basic.ftp.model.FTP;
import com.qinweizhao.basic.ftp.util.FtpUtil;
import com.qinweizhao.basic.ftp.util.OutputUtil;
import org.apache.ftpserver.ftplet.FtpException;

import java.io.File;
import java.util.UUID;

/**
 * @author qinweizhao
 * @since 2023-05-22
 */
public class Main {

    public static void main(String[] args) {

//        String fileName = args[0];
        String fileName = "/Users/weizhao/Code/qwz/qwz-sample/basic/b-ftp/pom.xml";

        long start = System.currentTimeMillis();
        System.out.println("程序开始运行，当前时间点：" + start);

        try {
            // 连接FTP
            FTP ftp = FtpUtil.getFtp();
            // 指定上传目录名
            ftp.setPath("Date/" + UUID.randomUUID());
            // 上传pageName1
            File file = new File(fileName);
            if (file.exists()) {
                ftp.setFileName(String.valueOf(UUID.randomUUID()));
                System.out.println("准备进行上传···");
                System.out.println("ftp.getPath() : " + ftp.getPath() + "  ftp.getFileName():" + ftp.getFileName());
                FtpUtil.upload(ftp.getPath(), file, ftp.getFileName());
                System.out.println("文件上传成功，耗时：" + (System.currentTimeMillis() - start));
            } else {
                System.out.println("文件 " + file.getAbsolutePath() + " 不存在！");
            }
        } catch (FtpException e) {
            e.printStackTrace();
            OutputUtil.SystemOutput("FTP上传失败！");
        } finally {
            FtpUtil.closeFtp();
        }
    }
}