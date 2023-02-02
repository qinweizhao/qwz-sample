package com.qinweizhao.basic.thread;

/**
 * 定义销售员工类
 */
class Sale {
    private String name;

    public Sale(String name) {
        this.name = name;
    }

    /**
     * 领取奖金
     */
    synchronized public static void money() {
        try {
            System.out.println(Thread.currentThread().getName() + " 被领导表扬");
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName() + " 拿钱");
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName() + " 对公司表示感谢");
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName() + " 开开心心的拿钱走人");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Programmer {
    private String name;

    public Programmer(String name) {
        this.name = name;
    }

    /**
     * 打开电脑
     */
    synchronized public void computer() {
        try {
            System.out.println(this.name + " 接通电源");
            Thread.sleep(500);
            System.out.println(this.name + " 按开机按键");
            Thread.sleep(500);
            System.out.println(this.name + " 系统启动中");
            Thread.sleep(500);
            System.out.println(this.name + " 系统启动成功");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 编码
     */
    synchronized public void coding() {
        try {
            System.out.println(this.name + " 双击Idea");
            Thread.sleep(500);
            System.out.println(this.name + " Idea启动完毕");
            Thread.sleep(500);
            System.out.println(this.name + " 开开心心的写代码");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 去卫生间
     */
    public void wc() {
        synchronized ("suibian") {
            try {
                System.out.println(this.name + " 打开卫生间门");
                Thread.sleep(500);
                System.out.println(this.name + " 开始排泄");
                Thread.sleep(500);
                System.out.println(this.name + " 冲水");
                Thread.sleep(500);
                System.out.println(this.name + " 离开卫生间");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 领取奖金
     */
    public void money() {
        synchronized (Programmer.class) {
            try {
                System.out.println(this.name + " 被领导表扬");
                Thread.sleep(500);
                System.out.println(this.name + " 拿钱");
                Thread.sleep(500);
                System.out.println(this.name + " 对公司表示感谢");
                Thread.sleep(500);
                System.out.println(this.name + " 开开心心的拿钱走人");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Manager {
    private String name;

    public Manager(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    /**
     * 敬酒
     */
    public void cheers(String mName, String eName) {
        try {
            System.out.println(mName + " 来到 " + eName + " 面前");
            Thread.sleep(500);
            System.out.println(eName + " 拿起酒杯");
            Thread.sleep(500);
            System.out.println(mName + " 和 " + eName + " 干杯");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 打开电脑的工作线程
 */
class Working1 extends Thread {
    private Programmer p;

    public Working1(Programmer p) {
        this.p = p;
    }

    @Override
    public void run() {
        this.p.computer();
    }
}

/**
 * 编写代码的工作线程
 */
class Working2 extends Thread {
    private Programmer p;

    public Working2(Programmer p) {
        this.p = p;
    }

    @Override
    public void run() {
        this.p.coding();
    }
}

/**
 * 去卫生间的线程
 */
class WC extends Thread {
    private Programmer p;

    public WC(Programmer p) {
        this.p = p;
    }

    @Override
    public void run() {
        this.p.wc();
    }
}

/**
 * 程序员领取奖金
 */
class ProgrammerMoney extends Thread {
    private Programmer p;

    public ProgrammerMoney(Programmer p) {
        this.p = p;
    }

    @Override
    public void run() {
        this.p.money();
    }
}

/**
 * 销售部门领取奖金
 */
class SaleMoneyThread extends Thread {
    private Sale p;

    public SaleMoneyThread(Sale p) {
        this.p = p;
    }

    @Override
    public void run() {
        this.p.money();
    }
}

/**
 * 敬酒线程类
 */
class CheersThread extends Thread {
    private Manager manager;
    private String name;

    public CheersThread(String name, Manager manager) {
        this.name = name;
        this.manager = manager;
    }

    @Override
    public void run() {
        synchronized (this.manager) {
            this.manager.cheers(this.manager.getName(), name);
        }
    }
}

public class TestSyncThread {
    public static void main(String[] args) {
        /*Programmer p = new Programmer("张三");
        new Working1(p).start();
        new Working2(p).start();*/
        /*Programmer p = new Programmer("张三");
        Programmer p1 = new Programmer("李四");
        Programmer p2 = new Programmer("王五");
        new WC(p).start();
        new WC(p1).start();
        new WC(p2).start();*/
        /*Programmer p = new Programmer("张三");
        Programmer p1 = new Programmer("李四");
        new ProgrammerMoney(p).start();
        new ProgrammerMoney(p1).start();*/
       /* Sale sale = new Sale("王晓丽");
        Sale sale1 = new Sale("张丽丽");
        new SaleMoneyThread(sale).start();
        new SaleMoneyThread(sale1).start();*/
        /*Programmer p1 = new Programmer("李四");
        new ProgrammerMoney(p1).start();
        Sale sale1 = new Sale("张丽丽");
        new SaleMoneyThread(sale1).start();*/
        Manager manager = new Manager("张三丰");
        new CheersThread("张三", manager).start();
        new CheersThread("李四", manager).start();

    }
}
