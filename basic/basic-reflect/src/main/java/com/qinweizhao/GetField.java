package com.qinweizhao;

import java.lang.reflect.Field;

public class GetField {
    public static void main(String[] args) throws Exception {
        Class clazz = Users.class;
        Field[] fields = clazz.getFields();
        for (Field f : fields) {
            System.out.println(f);
            System.out.println(f.getName());
        }
        System.out.println("------------------------");
        Field[] fields2 = clazz.getDeclaredFields();
        for (Field f : fields2) {
            System.out.println(f);
            System.out.println(f.getName());
        }
        System.out.println("------------------------");
        Field field = clazz.getField("userage");
        System.out.println(field);
        System.out.println("---------------------");
        Field field1 = clazz.getDeclaredField("username");
        System.out.println(field1);
    }
}
