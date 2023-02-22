package com.qinweizhao.basic.tool.sftp;

import com.jcraft.jsch.SftpException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

/**
 * @author qinweizhao
 * @since 2023-02-22
 */

public class SftpTests {

    //上传文件测试
    public static void main(String[] args) throws SftpException, IOException {
        SftpUtil sftp = new SftpUtil("qwz", "Qwz#1201", "10.200.47.109", 22);
        sftp.login();
        File file = new File("/Users/weizhao/Code/yet/cpl-projects/cpl-data/HELP.md");
        InputStream is = Files.newInputStream(file.toPath());

        sftp.upload("/", "HELP.md", is);

        sftp.logout();
    }
}
