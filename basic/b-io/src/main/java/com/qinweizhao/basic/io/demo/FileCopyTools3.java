package com.qinweizhao.basic.io.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author qinweizhao
 * @since 2021-11-26
 */
public class FileCopyTools3 {
    public static void main(String[] args) {
        copyFile("d:/2.txt", "d:/22.txt");
    }

    /**
     * 基于字符流缓冲流实现文件拷贝
     */
    public static void copyFile(String src, String des) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(src));
            bw = new BufferedWriter(new FileWriter(des));
            String temp = "";
            while ((temp = br.readLine()) != null) {
                bw.write(temp);
                bw.newLine();
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
