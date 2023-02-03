package com.qinweizhao.basic.reflect;


import java.lang.reflect.Method;

public class GetMethod2 {
    public static void main(String[] args) throws Exception {
        Class clazz = Users.class;
        Method method = clazz.getMethod("setUsername", String.class);
        //实例化对象
        Object obj = clazz.newInstance();
        //通过setUserName赋值
        method.invoke(obj, "oldlu");

        //通过getUserName获取值
        Method method1 = clazz.getMethod("getUsername");
        Object value = method1.invoke(obj);
        System.out.println(value);
    }
}
