package com.qinweizhao.basic.thread;

class Alive implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().isAlive() + " 2");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class AliveThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new Alive());
        System.out.println(thread.isAlive() + " 1");
        thread.start();
        System.out.println(thread.isAlive() + " 3");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.isAlive() + " 4");
    }
}
