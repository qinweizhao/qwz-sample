package com.io;

import java.io.File;

/**
 * @author qinweizhao
 * @since 2021/11/26
 */
public class DirectoryDemo {
    public static void main(String[] args) {
        //创建File对象
        File file = new File("d:/b/c");
        //System.out.println(file.mkdir());
        //System.out.println(file.mkdirs());
        //System.out.println(file.exists());
        //System.out.println(file.isDirectory());
        //System.out.println(file.getParent());
        // System.out.println(file.getParentFile().getName());
        File file2 = new File("d:/");
        String[] arr = file2.list();
        for (String temp : arr) {
            System.out.println(temp);
        }
        System.out.println("-----------------------");
        File[] arr2 = file2.listFiles();
        for (File temp : arr2) {
            System.out.println(temp);
        }
    }
}
