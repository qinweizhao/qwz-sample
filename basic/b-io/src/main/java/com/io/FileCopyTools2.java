package com.io;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author qinweizhao
 * @since 2021/11/26
 */
public class FileCopyTools2 {
    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader("d:/2.txt");
            fw = new FileWriter("d:/3.txt");
            char[] buffer = new char[1024];
            int temp = 0;
            while ((temp = fr.read(buffer)) != -1) {
                fw.write(buffer, 0, temp);
            }
            fw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
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
