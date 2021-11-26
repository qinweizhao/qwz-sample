package com.qinweizhao;


/**
 * 定义馒头类
 */
class ManTou {
    private int id;

    public ManTou(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}

/**
 * 定义缓冲区类
 */
class SyncStack {
    //定义存放馒头的盒子
    private ManTou[] mt = new ManTou[10];
    //定义操作盒子的索引
    private int index;

    /**
     * 放馒头
     */
    public synchronized void push(ManTou manTou) {
        //判断盒子是否已满
        while (this.index == this.mt.length) {
            try {
                /**
                 * 语法：wait(),该方法必须要在synchronized块中调用。
                 * wait执行后，线程会将持有的对象锁释放，并进入阻塞状态，
                 * 其他需要该对象锁的线程就可以继续运行了。
                 */
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //唤醒取馒头的线程
        /**
         * 语法：该方法必须要在synchronized块中调用。
         * 该方法会唤醒处于等待状态队列中的一个线程。
         */
        this.notify();
        this.mt[this.index] = manTou;
        this.index++;
    }

    /**
     * 取馒头
     */
    public synchronized ManTou pop() {
        while (this.index == 0) {
            try {
                /**
                 * 语法：wait(),该方法必须要在synchronized块中调用。
                 * wait执行后，线程会将持有的对象锁释放，并进入阻塞状态，
                 * 其他需要该对象锁的线程就可以继续运行了。
                 */
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        this.index--;
        return this.mt[this.index];
    }
}

/**
 * 定义生产者线程类
 */
class ShengChan extends Thread {
    private SyncStack ss;

    public ShengChan(SyncStack ss) {
        this.ss = ss;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("生产馒头：" + i);
            ManTou manTou = new ManTou(i);
            this.ss.push(manTou);
        }
    }
}

/**
 * 定义消费者线程类
 */
class XiaoFei extends Thread {
    private SyncStack ss;

    public XiaoFei(SyncStack ss) {
        this.ss = ss;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            ManTou manTou = this.ss.pop();
            System.out.println("消费馒头：" + i);
        }
    }
}

public class ProduceThread {
    public static void main(String[] args) {
        SyncStack ss = new SyncStack();
        new ShengChan(ss).start();
        new XiaoFei(ss).start();
    }
}
