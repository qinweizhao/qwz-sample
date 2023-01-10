package com.qinweizhao.jvm.ma;

import java.io.Serializable;

/**
 * @author qinweizhao
 * @since 2022-04-03
 */
public class MethodInnerStructure extends Object implements Comparable<String>, Serializable {

    /**
     * 属性
     */
    public int num = 10;

    private static String str = "测试方法的内部结构";

    /**
     * 方法
     */
    public void test1(){
        int count = 20;
        System.out.println("count = " + count);
    }
    public static int test2(int cal){
        int result = 0;
        try {
            int value = 30;
            result = value / cal;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

}
