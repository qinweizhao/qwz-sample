package com.qinweizhao.basic.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test3 {
    public static void main(String[] args) throws Exception {
        Users users = new Users();
        Class clazz = users.getClass();
        Field field = clazz.getDeclaredField("username");
        //忽略安全检查
        field.setAccessible(true);
        field.set(users, "oldlu");
        Object object = field.get(users);
        System.out.println(object);
        System.out.println("-----------------------------");
        Method method = clazz.getDeclaredMethod("suibian");
        method.setAccessible(true);
        method.invoke(users);
    }
}
