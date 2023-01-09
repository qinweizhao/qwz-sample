package com.qinweizhao.io;

import java.io.*;

/**
 * @author qinweizhao
 * @since 2021-11-26
 */
public class LineNumberDemo2 {
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("d:/sxt.txt")));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d:/sxt3.txt")));
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
