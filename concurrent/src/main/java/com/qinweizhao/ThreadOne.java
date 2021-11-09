package com.qinweizhao;

/**
 * @author YVKG
 */
public class ThreadOne extends Thread {

    private static final int SIZE = 10;

    @Override
    public void run() {
        for (int i = 0; i < SIZE; i++) {
            //getName()方法是返回线程名称
            System.out.println(this.getName() + ":" + i);
        }
    }
}
