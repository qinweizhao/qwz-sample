package com.qinweizhao.basic.io.zip;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.ZipParameters;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



public class Zip {


    public static void main(String[] args) throws IOException {
        Map<String, String> fileNamesMap = new HashMap<>();
        fileNamesMap.put("firstFile.txt","newFileFirst.txt");
        ZipFile zipFile = new ZipFile("C:\\Users\\YVKG\\Desktop\\test\\filename.zip");
        zipFile.addFile(new File("C:\\Users\\YVKG\\Desktop\\test\\firstFile.txt"));
        zipFile.renameFile("firstFile.txt","newfirstFile.pdf");
        zipFile.addFile(new File("C:\\Users\\YVKG\\Desktop\\test\\firstFile.txt"));


       // zipFile.addFile(new File("C:\\Users\\YVKG\\Desktop\\test\\firstFile.txt"));


    }

}
