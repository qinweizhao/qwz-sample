package com.qinweizhao.io;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author qinweizhao
 * @since 2021/11/26
 */
public class SecondDemo {
    public static void main(String[] args) {
        File file = new File("d:/a");
        System.out.println(file.delete());
        FileInputStream fis = null;
        try {
            //创建字节输入流对象
            fis = new FileInputStream("d:/a.txt");
            StringBuilder sb = new StringBuilder();
            int temp = 0;
            while ((temp = fis.read()) != -1) {
                System.out.println(temp);
                sb.append((char) temp);
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
