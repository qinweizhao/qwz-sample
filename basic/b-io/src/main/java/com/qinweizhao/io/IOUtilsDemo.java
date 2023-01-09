package com.qinweizhao.io;


import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;

/**
 * @author qinweizhao
 * @since 2021-11-26
 */
public class IOUtilsDemo {
    public static void main(String[] args) throws Exception {
        String content = IOUtils.toString(new FileInputStream("d:/sxt.txt"), "utf-8");
        System.out.println(content);
    }
}
