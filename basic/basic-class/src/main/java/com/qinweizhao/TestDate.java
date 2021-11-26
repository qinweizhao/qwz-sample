package com.qinweizhao;

import java.util.Date;

public class TestDate {
    public static void main(String[] args) {
        long a = Long.MAX_VALUE / (1000L * 3600 * 24 * 365);
        System.out.println(a);  //大约表示到：2.9亿年后

        long nowNum = System.currentTimeMillis();   //代表当前时刻的毫秒数
        System.out.println(nowNum);

        Date d1 = new Date();       //如果没有传参，代表当前时刻
        System.out.println(d1);
        System.out.println(d1.getTime());

        Date d2 = new Date(1000L * 3600 * 24 * 365 * 250);
        System.out.println(d2);


    }
}
