package com.qinweizhao.basic.io.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author qinweizhao
 * @since 2021-11-26
 */
public class LineNumberDemo {
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader("d:/sxt2.txt"));
            bw = new BufferedWriter(new FileWriter("d:/sxt3.txt"));
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
