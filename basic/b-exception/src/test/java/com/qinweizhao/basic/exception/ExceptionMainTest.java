package com.qinweizhao.basic.exception;

import com.qinweizhao.basic.exception.ExceptionMain;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author qinweizhao
 * @since 2021-11-26
 */
class ExceptionMainTest {

    @Test
    void readFile() /*throws Exception*/ {
        try {
            ExceptionMain.readFile("d:/a.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    void test2() {
        try (FileReader reader = new FileReader("d:/a.txt");) {
            char c = (char) reader.read();
            char c2 = (char) reader.read();
            System.out.println("" + c + c2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    void test3() {
        System.out.println("step1");
        try {
            //运行时异常
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("step2");

        File f = new File("D:/a.txt");
//        f.createNewFile();        checkedException：编译时检查的异常

    }


    @Test
    void test4() {
        FileReader reader = null;
        try {
            reader = new FileReader("d:/a.txt");
            char c = (char) reader.read();
            char c2 = (char) reader.read();
            System.out.println("" + c + c2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}