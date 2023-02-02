package com.qinweizhao.basic.thread;

public class TestThread extends Thread {
    public TestThread() {
        System.out.println(this.getName());
    }

    public static void main(String[] args) {
        System.out.println("主线程开始");
        TestThread t1 = new TestThread();
        //启动线程
        t1.start();
        TestThread t2 = new TestThread();
        //启动线程
        t2.start();
        System.out.println("主线程结束");
    }

    /**
     * 线程的线程体
     */
    @Override
    public void run() {
        System.out.println(this.getName() + "线程开始");
        for (int i = 0; i < 20; i++) {
            System.out.println(this.getName() + " " + i);
        }
        System.out.println(this.getName() + "线程结束");
    }
}
