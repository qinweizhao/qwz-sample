package com.qinweizhao.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author qinweizhao
 * @since 2021/11/26
 */
public class ObjectInputStreamBasicTypeDemo {
    public static void main(String[] args) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("d:/sxt5.txt")));
            //必须要按照写入的顺序读取数据
            System.out.println("int: " + ois.readInt());
            System.out.println("double: " + ois.readDouble());
            System.out.println("char: " + ois.readChar());
            System.out.println("boolean: " + ois.readBoolean());
            System.out.println("String: " + ois.readUTF());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
