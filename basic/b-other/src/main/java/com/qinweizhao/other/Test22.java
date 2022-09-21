package com.qinweizhao.other;

public class Test22 {
    public static void main(String[] args) {
        long d1 = System.currentTimeMillis();
        long result = factorial(10);
        long d2 = System.currentTimeMillis();
        System.out.println("阶乘的结果：" + result);
        System.out.println("耗时：" + (d2 - d1));
    }

    /**
     * 求阶乘的方法
     */
    static long factorial(int n) {
        if (n == 1) {//递归头
            return 1;
        } else {//递归体
            return n * factorial(n - 1);//n! = n * (n-1)!
        }
    }
}