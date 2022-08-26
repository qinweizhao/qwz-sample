package com.qinweizhao.io;

import java.io.ByteArrayOutputStream;

/**
 * @author qinweizhao
 * @since 2021/11/26
 */
public class ByteArrayOutputDemo {
    public static void main(String[] args) {
        ByteArrayOutputStream bos = null;
        try {
            StringBuilder sb = new StringBuilder();
            bos = new ByteArrayOutputStream();
            bos.write('a');
            bos.write('b');
            bos.write('c');
            byte[] arr = bos.toByteArray();
            for (int i = 0; i < arr.length; i++) {
                sb.append((char) arr[i]);
            }
            System.out.println(sb.toString());
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
