package com.qinweizhao.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * @author qinweizhao
 * @since 2021-11-26
 */
public class ObjectOutputStreamObjectTypeDemo {
    public static void main(String[] args) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("d:/sxt6.txt"));
            Users users = new Users(1, "Oldlu", "18");
            oos.writeObject(users);
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
