package com.qinweizhao;

/**
 * 口红类
 */
class Lipstick {

}

/**
 * 镜子类
 */
class Mirror {

}

/**
 * 化妆线程类
 */
class Makeup extends Thread {
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();
    private int flag; //flag=0:拿着口红。flag!=0:拿着镜子
    private String girlName;

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public void setGirlName(String girlName) {
        this.girlName = girlName;
    }

    @Override
    public void run() {
        this.doMakeup();
    }

    /**
     * 开始化妆
     */
    public void doMakeup() {
        if (flag == 0) {
            synchronized (lipstick) {
                System.out.println(this.girlName + " 拿着口红");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (mirror) {
                System.out.println(this.girlName + " 拿着镜子");
            }
        } else {
            synchronized (mirror) {
                System.out.println(this.girlName + " 拿着镜子");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (lipstick) {
                System.out.println(this.girlName + " 拿着口红");
            }
        }
    }
}

public class DeadLockThread {
    public static void main(String[] args) {
        Makeup makeup = new Makeup();
        makeup.setFlag(0);
        makeup.setGirlName("大丫");
        Makeup makeup1 = new Makeup();
        makeup1.setFlag(1);
        makeup1.setGirlName("小丫");
        makeup.start();
        makeup1.start();
    }
}
