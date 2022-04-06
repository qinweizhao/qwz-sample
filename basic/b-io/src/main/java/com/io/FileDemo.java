package com.io;

import java.io.File;

/**
 * @author qinweizhao
 * @since 2021/11/26
 */
public class FileDemo {
    public static void main(String[] args) throws Exception {
        //创建File对象
        File file = new File("d:/aa.txt");
        System.out.println(file.createNewFile());
        //System.out.println(file.delete());
        System.out.println(file.exists());
        System.out.println(file.getName());
        System.out.println(file.isFile());
        System.out.println(file.isHidden());
    }
}
