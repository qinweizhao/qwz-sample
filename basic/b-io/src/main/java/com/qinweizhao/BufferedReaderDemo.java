package com.qinweizhao;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author qinweizhao
 * @since 2021/11/26
 */
public class BufferedReaderDemo {
    public static void main(String[] args) {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("d:/sxt.txt");
            br = new BufferedReader(fr);
            String temp = "";
            while ((temp = br.readLine()) != null) {
                System.out.println(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
