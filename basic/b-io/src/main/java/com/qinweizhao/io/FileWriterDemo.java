package com.qinweizhao.io;

import java.io.FileWriter;

/**
 * @author qinweizhao
 * @since 2021/11/26
 */
public class FileWriterDemo {
    public static void main(String[] args) {
        FileWriter fw = null;
        FileWriter fw2 = null;
        try {
            //创建字符输出流对象
            fw = new FileWriter("d:/sxt.txt");
            fw.write("你好尚学堂\r\n");
            fw.write("你好Oldlu\r\n");
            fw.flush();

            fw2 = new FileWriter("d:/sxt.txt", true);
            fw2.write("何以解忧\r\n唯有尚学堂");
            fw2.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
                if (fw2 != null) {
                    fw2.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
