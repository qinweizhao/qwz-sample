package com.qinweizhao.basic.reflect;

import java.lang.reflect.Method;

public class Test2 {
    public static void main(String[] args) {
        try {
            //反射耗时
            Class clazz = Class.forName("com.bjsxt.Users");
            Users users = (Users) clazz.newInstance();
            long reflectStart = System.currentTimeMillis();
            Method method = clazz.getMethod("setUsername", String.class);
            method.setAccessible(true);
            for (int i = 0; i < 100000000; i++) {
                method.invoke(users, "oldlu");
            }
            long reflectEnd = System.currentTimeMillis();
            //非反射方式的耗时
            long start = System.currentTimeMillis();
            Users u = new Users();
            for (int i = 0; i < 100000000; i++) {
                u.setUsername("oldlu");
            }
            long end = System.currentTimeMillis();
            System.out.println("反射执行时间：" + (reflectEnd - reflectStart));
            System.out.println("普通方式执行时间：" + (end - start));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
