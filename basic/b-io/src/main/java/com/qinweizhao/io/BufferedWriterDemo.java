package com.qinweizhao.io;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * @author qinweizhao
 * @since 2021/11/26
 */
public class BufferedWriterDemo {
    public static void main(String[] args) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter("d:/sxt2.txt");
            bw = new BufferedWriter(fw);
            bw.write("你好尚学堂");
            bw.write("你好Oldlu");
            bw.newLine();
            bw.write("何以解忧");
            bw.newLine();
            bw.write("唯有尚学堂");
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
