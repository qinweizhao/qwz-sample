package com.qinweizhao.jvm.classloader;

/**
 * 虚拟机必须保证一个类的 clinit<>() 方法在多线程下被同步加锁。
 * @author qinweizhao
 * @since 2021/12/17
 */
public class ClinitThread {

    /**
     * 只能执行一次初始化的过程，即同步加锁的过程
     * @param args args
     */
    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + "开始");
            DeadThread dead = new DeadThread();
            System.out.println(Thread.currentThread().getName() + "结束");
        };

        Thread t1 = new Thread(r,"线程1");
        Thread t2 = new Thread(r,"线程2");

        t1.start();
        t2.start();
    }
}

class DeadThread{
    static{
        if(true){
            System.out.println(Thread.currentThread().getName() + "初始化当前类");
            while(true){

            }
        }
    }
}
