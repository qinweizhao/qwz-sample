package com.qinweizhao.basic.features.eight.lambda;

public class Test3 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " 开始");
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }, "Lambda Thread ").start();
        System.out.println(Thread.currentThread().getName() + " 结束");
    }
}
