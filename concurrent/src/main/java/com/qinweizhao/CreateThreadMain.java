package com.qinweizhao;

/**
 * @author YVKG
 */
@SuppressWarnings("all")
public class CreateThreadMain {

    public static void main(String[] args) {
        // 创建线程对象 1
        ThreadOne threadOne = new ThreadOne();
        // 启动线程
        threadOne.start();

        // 创建线程对象 2
        // 把实现了Runnable接口的对象作为参数传入
        Thread thread1 = new Thread(new ThreadTwo());
        //启动线程；
        thread1.start();
    }

}
