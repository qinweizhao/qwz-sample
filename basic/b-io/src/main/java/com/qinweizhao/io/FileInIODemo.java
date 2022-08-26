package com.qinweizhao.io;

import java.io.*;

/**
 * @author qinweizhao
 * @since 2021/11/26
 */
public class FileInIODemo {
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("d:/sxt.txt")));
            bw = new BufferedWriter(new FileWriter(new File("d:/sxt8.txt")));
            String temp = "";
            int i = 1;
            while ((temp = br.readLine()) != null) {
                bw.write(i + "," + temp);
                bw.newLine();
                i++;
            }
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (bw != null) {
                    bw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
