package com.qinweizhao.basic.other;

/**
 * @author qinweizhao
 * @since 2023-06-15
 */
public class AppTests {
   static  {
        System.out.println("static {}");
    }
    {
        System.out.println("{}");
    }
    AppTests(){
        System.out.println("AppTests()");
    }

}
