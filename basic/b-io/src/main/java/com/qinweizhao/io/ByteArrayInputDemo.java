package com.qinweizhao.io;

import java.io.ByteArrayInputStream;

/**
 * @author qinweizhao
 * @since 2021-11-26
 */
public class ByteArrayInputDemo {
    public static void main(String[] args) {
        byte[] arr = "abcdefg".getBytes();
        ByteArrayInputStream bis = null;
        StringBuilder sb = new StringBuilder();
        try {
            //该构造方法的参数是一个字节数组，这个字节数组就是数据源
            bis = new ByteArrayInputStream(arr);
            int temp = 0;
            while ((temp = bis.read()) != -1) {
                sb.append((char) temp);
            }
            System.out.println(sb.toString());
        } finally {
            try {
                bis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
