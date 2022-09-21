package com.qinweizhao.other;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestFile {

    public static void main(String[] args) throws IOException {
        File f1 = new File("d:/movies/功夫熊猫.mp4");
//        File f1 = new File("d:\\movies\\功夫熊猫.mp4");
        File f2 = new File("d:/movies");

        System.out.println(System.getProperty("user.dir")); //项目的路径
        File f3 = new File(System.getProperty("user.dir"));

        f1.createNewFile();
        System.out.println("File是否存在：" + f1.exists());
        System.out.println("File是否是目录：" + f1.isDirectory());
        System.out.println("File是否是文件：" + f1.isFile());
        System.out.println("File最后修改时间：" + new Date(f1.lastModified()));
        System.out.println("File的大小：" + f1.length());
        System.out.println("File的文件名：" + f1.getName());
        System.out.println("File的目录路径：" + f1.getPath());

        File f4 = new File("D:/movies/大陆/学习/编程/尚学堂/高淇");
        f4.mkdirs();
//        f4.delete();

    }


}
