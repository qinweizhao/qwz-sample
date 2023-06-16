package com.qinweizhao.basic.other;

/**
 * @author qinweizhao
 * @since 2023-06-16
 */
public class Start {
    static  {
        System.out.println("static {}");
    }
    {
        System.out.println("{}");
    }
    Start(){
        System.out.println("AppTests()");
    }
}
