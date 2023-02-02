package com.qinweizhao.basic.thread;

/**
 * 儿子买烟线程
 */
class SonThread implements Runnable {

    @Override
    public void run() {
        System.out.println("儿子出门买烟");
        System.out.println("儿子买烟需要10分钟");
        for (int i = 0; i < 10; i++) {
            System.out.println("第" + i + "分钟");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("儿子买烟回来了");
    }
}

/**
 * 爸爸抽烟线程
 */
class FatherThread implements Runnable {

    @Override
    public void run() {
        System.out.println("爸爸想抽烟，发现烟抽完了");
        System.out.println("爸爸让儿子去买一包红塔山");
        Thread t = new Thread(new SonThread());
        t.start();
        System.out.println("等待儿子买烟回来");
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("爸爸出门找儿子");
            System.exit(1);
        }
        System.out.println("爸爸高兴的接过烟，并把零钱给了儿子");
    }
}

public class JoinDemo {
    public static void main(String[] args) {
        System.out.println("爸爸和儿子买烟的故事");
        Thread t = new Thread(new FatherThread());
        t.start();
    }
}


