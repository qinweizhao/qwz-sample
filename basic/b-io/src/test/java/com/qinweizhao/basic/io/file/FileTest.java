package com.qinweizhao.basic.io.file;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author qinweizhao
 * @since 2022-08-26
 */
public class FileTest {

    /**
     * 删除文件
     */
    @Test
    void deleteFile() {
        String pathName = "/Users/weizhao/Code/qwz/qwz-sample/basic/b-io/src/main/resources/del.txt";
        File file = new File(pathName);
        file.deleteOnExit();
        System.out.println("执行结束");
    }


    @Test
    public void writeFile() {
        InputStream input = null;
        OutputStream output = null;
        try {
            File source = new File("E:\\PaddleOCR.zip");
            File dest = new File("C:\\Users\\YVKG\\Desktop\\VPF\\test.zip");
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[100];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
                output.close();
                System.out.println(System.currentTimeMillis());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
