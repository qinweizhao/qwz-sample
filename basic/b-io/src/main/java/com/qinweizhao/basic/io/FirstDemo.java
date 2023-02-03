package com.qinweizhao.basic.io;

import java.io.FileInputStream;

/**
 * @author qinweizhao
 * @since 2021-11-26
 */
public class FirstDemo {
    public static void main(String[] args) {

        FileInputStream fis = null;
        try {
            //创建字节输入流对象
            fis = new FileInputStream("d:/a.txt");
            int s1 = fis.read();//打印输入字符a对应的ascii码值97
            int s2 = fis.read();//打印输入字符b对应的ascii码值98
            int s3 = fis.read();//打印输入字符c对应的ascii码值99
            int s4 = fis.read();//由于文件内容已经读取完毕，则返回-1
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s3);
            System.out.println(s4);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
