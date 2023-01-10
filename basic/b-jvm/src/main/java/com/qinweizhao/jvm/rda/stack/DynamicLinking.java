package com.qinweizhao.jvm.rda.stack;

/**
 * 动态链接
 *
 * @author qinweizhao
 * @since 2022-04-01
 */
public class DynamicLinking {
    int num = 10;

    public void methodA() {
        System.out.println("methodA()....");
    }

    public void methodB() {
        System.out.println("methodB()....");
        methodA();
        num++;
    }
}
