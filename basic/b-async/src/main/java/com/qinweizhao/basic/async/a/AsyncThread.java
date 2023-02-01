package com.qinweizhao.basic.async.a;

/**
 * @author qinweizhao
 * @since 2023-02-01
 */
public class AsyncThread extends Thread {

    @Override
    public void run() {
        System.out.println("Current thread name:" + Thread.currentThread().getName() + " Send email success!");
    }

    public static void main(String[] args) {
        AsyncThread asyncThread = new AsyncThread();
        asyncThread.run();
    }

}