package com.qinweizhao;

/**
 * .class静态属性获取Class对象
 */
public class GetClass2 {
    public static void main(String[] args) {
        Class clazz = Users.class;
        Class clazz2 = Users.class;
        System.out.println(clazz);
        System.out.println(clazz.getName());
        System.out.println(clazz == clazz2);
    }
}
