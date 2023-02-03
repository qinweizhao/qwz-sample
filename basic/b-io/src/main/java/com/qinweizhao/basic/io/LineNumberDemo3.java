package com.qinweizhao.basic.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author qinweizhao
 * @since 2021-11-26
 */
public class LineNumberDemo3 {
    public static void main(String[] args) {
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("d:/sxt.txt")));
            pw = new PrintWriter("d:/sxt4.txt");
            String temp = "";
            int i = 1;
            while ((temp = br.readLine()) != null) {
                pw.println(i + "," + temp);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (pw != null) {
                    pw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
