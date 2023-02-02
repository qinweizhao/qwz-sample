package com.qinweizhao.basic.features.eight.lambda;

public class Test2 {
    public static void main(String[] args) {
        ReturnOneParam returnOneParam = Test::doubleNum;
        int value = returnOneParam.method(10);
        System.out.println(value);

        Test test = new Test();
        ReturnOneParam returnOneParam1 = test::addTwo;
        int value2 = returnOneParam1.method(10);
        System.out.println(value2);
    }
}
