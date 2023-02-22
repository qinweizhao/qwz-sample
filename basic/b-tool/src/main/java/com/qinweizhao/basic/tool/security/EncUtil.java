package com.qinweizhao.basic.tool.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EncUtil {
    /*
     * 加密 和 解密操作
     * sourceFilePath: 输入文件路径+文件名
     * targetFilePath: 输出文件路径+文件名*/

    public static void security(String sourceFilePath, String targetFilePath) throws IOException {
        File sourceFile = new File(sourceFilePath);
        File targetFile = new File(targetFilePath);
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(sourceFile);
            byte[] buffer = new byte[1024];
            int len = 0;
            outputStream = new FileOutputStream(targetFile);
            while ((len = inputStream.read(buffer)) > 0) {
                byte[] outputBuffer = new byte[len];
                //分别对每个字节进行异或操作
                for (int i = 0; i < len; i++) {
                    byte b = buffer[i];
                    b = (byte) (b ^ 25);
                    outputBuffer[i] = b;
                }
                outputStream.write(outputBuffer, 0, len);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    //加密解密是属于同一个方法;
    public static void main(String[] args) throws IOException {
        //加密方法
        String sourceFilePath = "D:\\A\\long.jpg";
        String targetFilePath = "D:\\AB\\long2.jpg";
        security(sourceFilePath, targetFilePath);

        //解密方法
        sourceFilePath = "D:\\AB\\long2.jpg";
        targetFilePath = "D:\\A\\long.jpg";
        security(targetFilePath, sourceFilePath);
    }
}
