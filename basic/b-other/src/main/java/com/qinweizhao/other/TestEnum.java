package com.qinweizhao.other;

import java.util.Random;

enum Season {
    SPRING, SUMMNER, AUTUMN, WINTER
}

enum Week {
    星期一, 星期二, 星期三, 星期四, 星期五, 星期六, 星期日
}

public class TestEnum {
    public static void main(String[] args) {
        System.out.println(Season.AUTUMN);

        // 枚举遍历
        for (Week k : Week.values()) {      //values()返回的：Week[] 里面包含了所有的枚举元素
            System.out.println(k);
        }

        Week[] ws = Week.values();
        System.out.println(ws[1]);

        int a = new Random().nextInt(4);   //0,1,2,3  //(int)(Math.random()*4)

        switch (Season.values()[a]) {
            case SPRING:
                System.out.println("春天");
                break;
            case SUMMNER:
                System.out.println("夏天");
                break;
            case AUTUMN:
                System.out.println("秋天");
                break;
            case WINTER:
                System.out.println("冬天");
                break;
        }


    }
}
