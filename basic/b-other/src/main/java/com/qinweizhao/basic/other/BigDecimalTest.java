package com.qinweizhao.basic.other;

import java.math.BigDecimal;

/**
 * @author qinweizhao
 * @since 2023-06-30
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal zero = BigDecimal.ZERO;


        BigDecimal num1 = new BigDecimal("100");
        BigDecimal num2 = new BigDecimal("-200");
        BigDecimal num3 = new BigDecimal("-200");


        BigDecimal add1 = zero.add(num1).add(num2).add(num3);
        System.out.println(add1);

        System.out.println(zero);



        System.out.println("num1 = " + num1 + ",num2 = " + num2);
        // num1 + num2
        BigDecimal add = num1.add(num2);
        System.out.println("num1 + num2 = " + add);

        // num2 - num1
        BigDecimal subtract = num2.subtract(num1);
        System.out.println("num2 - num1 = " + subtract);

        // num1 * mun2
        BigDecimal multiply = num1.multiply(num2);
        System.out.println("num1 * num2 = " + multiply);

        // num2 /num1
        BigDecimal divide = num2.divide(num1);
        System.out.println("num2 / num1 = " + divide);
    }
}
