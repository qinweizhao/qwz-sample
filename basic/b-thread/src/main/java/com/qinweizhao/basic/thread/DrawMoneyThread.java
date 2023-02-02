package com.qinweizhao.basic.thread;

/**
 * 账户类
 */
class Account {
    //账号
    private String accountNo;
    //账户的余额
    private double balance;

    public Account() {
    }

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

/**
 * 取款线程
 */
class DrawThread extends Thread {
    //账户对象
    private Account account;
    //取款金额
    private double drawMoney;

    public DrawThread(String name, Account account, double drawMoney) {
        super(name);
        this.account = account;
        this.drawMoney = drawMoney;
    }

    /**
     * 取款线程
     */
    @Override
    public void run() {
        synchronized (this.account) {
            //判断当前账户余额是否大于或等于取款金额
            if (this.account.getBalance() >= this.drawMoney) {
                System.out.println(this.getName() + " 取钱成功！吐出钞票：" + this.drawMoney);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //更新账户余额
                this.account.setBalance(this.account.getBalance() - this.drawMoney);
                System.out.println("\t 余额为：" + this.account.getBalance());
            } else {
                System.out.println(this.getName() + " 取钱失败，余额不足");
            }
        }
    }
}

public class DrawMoneyThread {
    public static void main(String[] args) {
        Account account = new Account("1234", 1000);
        new DrawThread("老公", account, 800).start();
        new DrawThread("老婆", account, 800).start();
    }
}
