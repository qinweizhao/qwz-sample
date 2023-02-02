package com.qinweizhao.basic.jvm.rda.stack;

import java.util.Date;

/**
 * 局部变量表
 *
 * @author qinweizhao
 * @since 2022-04-01
 */
public class LocalVariables {
    private int count = 0;

    //关于Slot的使用的理解
    public LocalVariables() {
        this.count = 1;
    }

    public static void main(String[] args) {
        LocalVariables test = new LocalVariables();
        int num = 10;
        test.test1();
    }

    public static void testStatic() {
        LocalVariables test = new LocalVariables();
        Date date = new Date();
        int count = 10;
        System.out.println(count);
        // 因为 this 变量不存在于当前方法的局部变量表中！！!
        // System.out.println(this.count);
    }

    public void test1() {
        Date date = new Date();
        String name1 = "qinweizhao.com";
        test2(date, name1);
        System.out.println(date + name1);
    }

    public String test2(Date dateP, String name2) {
        dateP = null;
        name2 = "qinweizhao";
        //占据两个slot
        double weight = 130.5;
        char gender = '男';
        return dateP + name2;
    }

    public void test3() {
        this.count++;
    }

    public void test4() {
        int a = 0;
        {
            int b = 0;
            b = a + 1;
        }
        // 变量 c 使用之前已经销毁的变量 b 占据的 slot 的位置
        int c = a + 1;
    }
}
