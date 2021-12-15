package com.qinweizhao.jvm.classloader;

/**
 * @author qinweizhao
 * @since 2021/12/14
 */
public class HelloApp {
    /**
     * 准备阶段 a = 0 ,初始化阶段赋值为 1
     */
    private static int a = 1;

    public static void main(String[] args) {
        System.out.println(a);
    }
}
