package com.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author qinweizhao
 * @since 2021/11/26
 */
public class ObjectInputStreamObjectTypeDemo {
    public static void main(String[] args) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("d:/sxt6.txt"));
            Users users = (Users) ois.readObject();
            System.out.println(users.getUserid() + "\t" + users.getUsername() + "\t" + users.getUserage());
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
