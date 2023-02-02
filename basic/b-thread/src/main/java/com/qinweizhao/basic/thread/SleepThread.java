package com.qinweizhao.basic.thread;

public class SleepThread implements Runnable {
    public static void main(String[] args) {
        System.out.println("主线程开始");
        Thread t = new Thread(new SleepThread());
        t.start();
        System.out.println("主线程结束");
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 线程开始");
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " 线程结束");
    }
}
