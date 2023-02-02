package com.qinweizhao.basic.thread;

public class YieldThread implements Runnable {
    public static void main(String[] args) {
        Thread t1 = new Thread(new YieldThread());
        Thread t2 = new Thread(new YieldThread());
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            if ("Thread-0".equals(Thread.currentThread().getName())) {
                if (i == 0) {
                    Thread.yield();
                }
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
