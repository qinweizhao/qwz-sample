package com.qinweizhao;

/**
 * getClass()获取Class对象
 */
public class GetClass1 {
    public static void main(String[] args) {
        Users users = new Users();
        Class clazz = users.getClass();
        Class clazz2 = users.getClass();
        System.out.println(clazz);
        System.out.println(clazz.getName());
        System.out.println(clazz == clazz2);
    }
}
