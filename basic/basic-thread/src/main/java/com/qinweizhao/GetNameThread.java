package com.qinweizhao;

class GetName1 extends Thread {
    @Override
    public void run() {
        System.out.println(this.getName() + " Thread");
    }
}

class GetName2 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Runnable");
    }
}

public class GetNameThread {
    public static void main(String[] args) {
        GetName1 getName1 = new GetName1();
        getName1.start();
        Thread thread = new Thread(new GetName2());
        thread.start();
    }
}
