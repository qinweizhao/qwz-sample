package com.qinweizhao.basic.features.eight.lambda;

public class Test7 {
    public static void main(String[] args) {
        int num = 10;
        NoReturnNoParam noReturnNoParam = () -> System.out.println(num);
        noReturnNoParam.method();
    }
}
