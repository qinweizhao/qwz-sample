package com.qinweizhao.exception;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author qinweizhao
 * @since 2021/11/26
 */
public class ExceptionMain {

    public static void readFile(String path) throws Exception {
        FileReader reader = null;
        try {
            reader = new FileReader(path);
            char c = (char) reader.read();
            char c2 = (char) reader.read();
            System.out.println("" + c + c2);
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

    public static void main(String[] args) {
        try {
            String s= null;
            Response.BAD_LICENCE_TYPE.assertNotNull(s);
        }catch (BusinessException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }


}
