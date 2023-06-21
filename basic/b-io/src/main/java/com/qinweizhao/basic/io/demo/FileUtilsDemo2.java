package com.qinweizhao.basic.io.demo;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileFilter;

/**
 * @author qinweizhao
 * @since 2021-11-26
 */
public class FileUtilsDemo2 {
    public static void main(String[] args) throws Exception {
        FileUtils.copyDirectory(new File("d:/a"), new File("c:/a"), new FileFilter() {
            //在文件拷贝时的过滤条件
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory() || pathname.getName().endsWith("html")) {
                    return true;
                }
                return false;
            }
        });
    }
}
