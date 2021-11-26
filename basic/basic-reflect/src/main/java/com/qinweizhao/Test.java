package com.qinweizhao;

import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws Exception {
        ReflectDemo rd = new ReflectDemo();
        if (args != null && args.length > 0) {
            //获取ReflectDemo的Class对象
            Class clazz = rd.getClass();
            //通过反射获取ReflectDemo下的所有方法
            Method[] methods = clazz.getMethods();
            for (String str : args) {
                for (int i = 0; i < methods.length; i++) {
                    if (str.equalsIgnoreCase(methods[i].getName())) {
                        methods[i].invoke(rd);
                        break;
                    }
                }
            }
        } else {
            rd.method1();
            rd.method2();
            rd.method3();
        }
    }
}
