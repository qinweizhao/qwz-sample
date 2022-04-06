package com.io;

import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * @author qinweizhao
 * @since 2021/11/26
 */
public class FileUtilsDemo1 {
    public static void main(String[] args) throws Exception {
        String content = FileUtils.readFileToString(new File("d:/sxt.txt"), "utf-8");
        System.out.println(content);
    }
}
