package com.qinweizhao.other;

public class StringTest {

    public static void main(String[] args) {

        String temNew1 = new String("ab");
        String temNew2 = new String("ab");

        String tem = "a" + "b";
        String temSum = "ab";


        System.out.println(temNew1 == tem);

        System.out.println(temNew1 == temSum);

        System.out.println(temNew1 == temNew2);

        System.out.println(temSum == tem);

    }
}
