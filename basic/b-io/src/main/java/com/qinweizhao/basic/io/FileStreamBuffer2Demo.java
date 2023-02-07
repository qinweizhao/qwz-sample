package com.qinweizhao.basic.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author qinweizhao
 * @since 2021-11-26
 */
public class FileStreamBuffer2Demo {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //创建文件字节输入流对象
            fis = new FileInputStream("d:/itbz.jpg");
            //创建文件字节输出流对象
            fos = new FileOutputStream("d:/cc.jpg");
            //创建一个缓冲区，提高读写效率
            byte[] buff = new byte[fis.available()];
            fis.read(buff);
            //将数据从内存中写入到磁盘中。
            fos.write(buff);
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}