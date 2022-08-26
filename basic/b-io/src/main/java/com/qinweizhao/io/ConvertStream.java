package com.qinweizhao.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author qinweizhao
 * @since 2021/11/26
 */
public class ConvertStream {
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            while (true) {
                bw.write("请输入：");
                bw.flush();
                String input = br.readLine();
                if ("exit".equals(input)) {
                    break;
                }
                bw.write("你输入的是：" + input);
                bw.newLine();
                bw.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (br != null) {
                    br.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
