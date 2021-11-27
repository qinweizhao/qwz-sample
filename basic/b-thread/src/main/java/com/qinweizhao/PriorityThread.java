package com.qinweizhao;

class Priority implements Runnable {
    private int num = 0;
    private boolean flag = true;

    @Override
    public void run() {
        while (this.flag) {
            System.out.println(Thread.currentThread().getName() + " " + num++);
        }
    }

    public void stop() {
        this.flag = false;
    }
}

public class PriorityThread {
    public static void main(String[] args) throws Exception {
        Priority p1 = new Priority();
        Priority p2 = new Priority();
        Thread t1 = new Thread(p1, "线程1");
        Thread t2 = new Thread(p2, "线程2");
        System.out.println(t1.getPriority());
        //Thread.MAX_PRIORITY = 10
        t1.setPriority(Thread.MAX_PRIORITY);
        //Thread.MAX_PRIORITY = 1
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        p1.stop();
        p2.stop();
    }
}
