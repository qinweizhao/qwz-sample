package com.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * @author qinweizhao
 * @since 2021/11/26
 */
public class ObjectOutputStreamBasicTypeDemo {
    public static void main(String[] args) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("d:/sxt5.txt")));
            oos.writeInt(10);
            oos.writeDouble(Math.random());
            oos.writeChar('a');
            oos.writeBoolean(true);
            oos.writeUTF("你好Oldlu");
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
