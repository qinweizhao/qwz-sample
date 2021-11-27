package com.qinweizhao;

import java.lang.reflect.Constructor;

public class GetConstructor {
    public static void main(String[] args) throws Exception {
        Class clazz = Users.class;
        Constructor[] arr = clazz.getDeclaredConstructors();
        for (Constructor c : arr) {
            System.out.println(c);
        }
        System.out.println("---------------------");
        Constructor[] arr1 = clazz.getConstructors();
        for (Constructor c : arr1) {
            System.out.println(c);
        }
        System.out.println("------------------------");
        Constructor c = clazz.getDeclaredConstructor(int.class);
        System.out.println(c);

        System.out.println("------------------------");
        Constructor c1 = clazz.getConstructor(null);
        System.out.println(c1);
    }
}
