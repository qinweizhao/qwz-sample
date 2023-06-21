package com.qinweizhao.basic.io.demo;

import java.io.*;

/**
 * @author qinweizhao
 */
public class FileByteStreamMain {
    private FileByteStreamMain() {

    }

    /**
     * 读取文件内容
     * 中文乱码
     *
     * @param fileName 文件名称
     */
    public static void readString(String fileName) {
        InputStream fis = null;
        try {
            fis = new FileInputStream(fileName);
            StringBuilder sb = new StringBuilder();
            int temp;
            while ((temp = fis.read()) != -1) {
                sb.append((char) temp);
            }
            System.out.println("sb = " + sb);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fis != null;
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 读取文件内容
     * 解决中文乱码
     *
     * @param fileName 文件名称
     */
    public static void readStringPlus(String fileName) {
        InputStream fis = null;
        Reader reader = null;
        try {
            fis = new FileInputStream(fileName);

            reader = new InputStreamReader(fis);
            BufferedReader bufReader = new BufferedReader(reader);
            String line;
            while ((line = bufReader.readLine()) != null) {
                System.out.println(line);
            }

            // OR
//            reader = new InputStreamReader(fis, StandardCharsets.UTF_8);
//            StringBuilder sb = new StringBuilder();
//            int temp;
//            while ((temp = reader.read()) != -1) {
//                sb.append((char) temp);
//            }
//            System.out.println("sb = " + sb);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fis != null;
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert reader != null;
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 写入到文件中
     *
     * @param str 字符串/字节数组
     */
    public static void writeString(String str) {
        OutputStream fos = null;
        try {
            // true表示内容会追加到文件末尾；false表示重写整个文件内容。
            fos = new FileOutputStream("src/main/resources/io/write.txt", true);
            //该方法是直接将一个字节数组写入文件中; 而write(int n)是写入一个字节
            byte[] bytes = str.getBytes();
            fos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fos != null;
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
