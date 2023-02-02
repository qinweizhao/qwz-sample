package com.qinweizhao.basic.features.eight.lambda;

/**
 * 无返回值，无参数
 */
@FunctionalInterface
interface NoReturnNoParam {
    void method();
}

/**
 * 无返回值，有一个参数
 */
@FunctionalInterface
interface NoReturnOneParam {
    void method(int a);
}

/**
 * 无返回值，有多个参数
 */
@FunctionalInterface
interface NoReturnMultiParam {
    void method(int a, int b);
}

/**
 * 有返回值，无参数
 */
@FunctionalInterface
interface ReturnNoParam {
    int method();
}

/**
 * 有返回值，有一个参数
 */
@FunctionalInterface
interface ReturnOneParam {
    int method(int a);
}

/**
 * 有返回值，有多个参数
 */
@FunctionalInterface
interface ReturnMultiParam {
    int method(int a, int b);
}

public class Test {
    public static void main(String[] args) {
        /**
         * 无返回值，无参数
         */
       /* NoReturnNoParam noReturnNoParam = ()->{
            System.out.println("NoReturnNoParam");
        };*/
        /**
         * 简化版
         */
        NoReturnNoParam noReturnNoParam = () -> System.out.println("NoReturnNoParam");
        noReturnNoParam.method();

        /**
         * 无返回值，有一个参数
         */
       /* NoReturnOneParam noReturnOneParam = (int a)->{
            System.out.println("NoReturnOneParam "+a);
        };*/
        /**
         * 简化版
         */
        NoReturnOneParam noReturnOneParam = a -> System.out.println("NoReturnOneParam " + a);
        noReturnOneParam.method(10);

        /**
         * 无返回值，有多个参数
         */
       /* NoReturnMultiParam noReturnMultiParam = (int a, int b)->{
            System.out.println("NoReturnMultiParam "+a+"\t"+b);
        };*/
        NoReturnMultiParam noReturnMultiParam = (a, b) -> System.out.println("NoReturnMultiParam " + a + "\t" + b);
        noReturnMultiParam.method(10, 20);

        /**
         * 有返回值，无参数
         */
       /* ReturnNoParam returnNoParam = ()->{
            System.out.print("ReturnNoParam ");
            return 10;
        };*/
        /**
         * 简化版
         */
        ReturnNoParam returnNoParam = () -> 10 + 20;
        System.out.println(returnNoParam.method());

        /**
         * 有返回值，有一个参数
         */
      /*  ReturnOneParam returnOneParam = (int a)->{
            System.out.print("ReturnOneParam ");
            return a;
        };*/
        /***
         * 简化版
         */
        ReturnOneParam returnOneParam = a -> a;
        System.out.println(returnOneParam.method(10));

        /**
         * 有返回值，有多个参数
         */
        /*ReturnMultiParam returnMultiParam = (int a ,int b)->{
            System.out.print("ReturnMultiParam ");
            return a+b;
        };*/
        /**
         * 简化版
         */
        ReturnMultiParam returnMultiParam = (a, b) -> a + b;
        System.out.println(returnMultiParam.method(10, 20));

    }

    /**
     * 要求：
     * 1,参数的个数以及类型需要与函数接口中的抽象方法一致。
     * 2,返回值类型要与函数接口中的抽象方法的返回值类型一致。
     *
     * @param a
     * @return
     */
    public static int doubleNum(int a) {
        return 2 * a;
    }

    public int addTwo(int a) {
        return a + 2;
    }
}
