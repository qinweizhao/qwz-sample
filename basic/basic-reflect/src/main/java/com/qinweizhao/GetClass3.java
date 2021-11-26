package com.qinweizhao;

/**
 * 通过Class.forName("class Name")获取Class对象
 */
public class GetClass3 {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("com.bjsxt.Users");
        Class clazz2 = Class.forName("com.bjsxt.Users");
        System.out.println(clazz);
        System.out.println(clazz.getName());
        System.out.println(clazz == clazz2);
    }
}
