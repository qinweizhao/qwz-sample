package com.qinweizhao.basic.thread;

/**
 * 守护线程类
 */
class Daemon implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class UsersThread implements Runnable {

    @Override
    public void run() {
        Thread t = new Thread(new Daemon(), "Daemon");
        //将该线程设置为守护线程
        t.setDaemon(true);
        t.start();
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class DaemonThread {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new UsersThread(), "UsersThread");
        t.start();
        Thread.sleep(1000);
        System.out.println("主线程结束");
    }
}
