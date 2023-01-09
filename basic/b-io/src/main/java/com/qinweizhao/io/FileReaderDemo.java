package com.qinweizhao.io;

import java.io.FileReader;

/**
 * @author qinweizhao
 * @since 2021-11-26
 */
public class FileReaderDemo {
    public static void main(String[] args) {
        FileReader frd = null;
        try {
            //创建文件字符输入流对象
            frd = new FileReader("d:/a.txt");
            int temp = 0;
            while ((temp = frd.read()) != -1) {
                System.out.println((char) temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (frd != null) {
                    frd.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
