package com.qinweizhao.io.file;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author qinweizhao
 * @since 2022/8/26
 */
public class FileTest {

    /**
     * 删除文件
     */
    @Test
    void deleteFile(){
        String pathName = "/Users/weizhao/Code/qwz/qwz-sample/basic/b-io/src/main/resources/del.txt";
        File file = new File(pathName);
        file.deleteOnExit();
        System.out.println("执行结束");
    }
}
