package com.qinweizhao.other;

/**
 * 递归结构
 */
public class Test01 {

    public static int num = 10;

    public static void a() {
        num--;
        System.out.println("Test01.a:" + num);
        if (num > 0) {
            a();
        }
    }

    public static void b() {
        System.out.println("Test01.b");
    }

    public static void main(String[] args) {
        a();
    }

}
