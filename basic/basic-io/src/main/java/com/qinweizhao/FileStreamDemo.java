package com.qinweizhao;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author qinweizhao
 * @since 2021/11/26
 */
public class FileStreamDemo {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //创建文件字节输入流对象
            fis = new FileInputStream("d:/itbz.jpg");
            //创建文件字节输出流对象
            fos = new FileOutputStream("d:/dd.jpg");
            int temp = 0;
            while ((temp = fis.read()) != -1) {
                fos.write(temp);
            }
            //将数据从内存中写入到磁盘中。
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
