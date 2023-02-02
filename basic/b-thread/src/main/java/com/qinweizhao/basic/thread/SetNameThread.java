package com.qinweizhao.basic.thread;

class SetName1 extends Thread {
    public SetName1(String name) {
        super(name);
    }

    public SetName1() {

    }

    @Override
    public void run() {
        System.out.println(this.getName());
    }
}

class SetName2 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

public class SetNameThread {
    public static void main(String[] args) {
        /*SetName1 setName1 = new SetName1();
        setName1.setName("SetName1");
        setName1.start();*/
        Thread thread = new Thread(new SetName2());
        thread.setName("SetName2");
        thread.start();
    }
}
