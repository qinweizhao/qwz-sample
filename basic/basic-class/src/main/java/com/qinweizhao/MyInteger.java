package com.qinweizhao;

/**
 * 定义一个简单的包装类，并不难！！！
 */
public class MyInteger {

    public static final int LOW = -128;
    public static final int HIGH = 127;
    private static MyInteger[] cache = new MyInteger[256];

    static {
        //[-128,127]
        for (int i = MyInteger.LOW; i <= HIGH; i++) {
            //-128,0;-127,1;-126,2;
            cache[i + 128] = new MyInteger(i);
        }
    }

    private int value;

    private MyInteger(int i) {
        this.value = i;
    }

    public static MyInteger valueOf(int i) {
        if (i >= LOW && i <= HIGH) {
            return cache[i + 128];
        }
        return new MyInteger(i);
    }

    public static void main(String[] args) {
        MyInteger m = MyInteger.valueOf(30);
        System.out.println(m);

    }

    @Override
    public String toString() {
        return this.value + "";
    }

    public int intValue() {
        return value;
    }


}
