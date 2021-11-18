package com.qinweizhao.bytestream;

import org.junit.jupiter.api.Test;

/**
 * @author qinweizhao
 */
class FileByteStreamMainTests {


    /**
     * 读取文件内容
     * 中文乱码
     */
    @Test
    void readString() {
        String fileName = "src/main/resources/io/read.txt";
        FileByteStreamMain.readString(fileName);
    }

    /**
     * 读取文件内容
     * 解决中文乱码
     */
    @Test
    void readStringPlus() {
        String fileName = "src/main/resources/io/read.txt";
        FileByteStreamMain.readStringPlus(fileName);
    }


    /**
     * 写入到文件中
     */
    @Test
    void writeString() {
        String str = "hello word";
        FileByteStreamMain.writeString(str);
    }
}