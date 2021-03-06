package com.qinweizhao;

import java.io.File;

public class TestFile6 {
    public static void main(String[] args) {
        File f = new File("D:\\JAVASE课程【尚学堂·百战程序员】");
        printFile(f, 0);
    }

    /**
     * 打印文件信息
     *
     * @param file  文件名称
     * @param level 层次数(实际就是：第几次递归调用)
     */
    static void printFile(File file, int level) {
        //输出层次数
        for (int i = 0; i < level; i++) {
            System.out.print("-");
        }
        //输出文件名
//		if(file.isDirectory()||file.getName().toLowerCase().endsWith(".mp4")) {	//文件名字过滤
        System.out.println(file.getName());
//		}
        //如果file是目录，则获取子文件列表，并对每个子文件进行相同的操作
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File temp : files) {
                //递归调用该方法：注意等+1
                printFile(temp, level + 1);
            }
        }
    }
}