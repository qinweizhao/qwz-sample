package com.qinweizhao;


public class StopThread implements Runnable {
    private boolean flag = true;

    public static void main(String[] args) throws Exception {
        System.out.println("主线程开始");
        StopThread st = new StopThread();
        Thread t1 = new Thread(st);
        t1.start();
        System.in.read();
        st.stop();
        System.out.println("主线程结束");
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 线程开始");
        int i = 0;
        while (flag) {
            System.out.println(Thread.currentThread().getName() + " " + i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " 线程结束");
    }

    public void stop() {
        this.flag = false;
    }
}
