package com.qinweizhao.basic.array;

/**
 * @author qinweizhao
 * @since 2021-11-26
 */
public class Test01 {

    public static void main(String[] args) {
        //数组的定义和初始化
//        int[]  arr1 = null;
        int[] arr1 = new int[5];    //默认初始化：数组元素相当于对象的属性，遵守对象属性默认初始化的规则。
        //动态初始化。根据索引直接赋值
        System.out.println(arr1[0]);
        System.out.println(arr1[1]);

        int arr2[] = {20, 30, 40};       //静态初始化

        System.out.println(arr2);

        //数组的遍历
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = i * 2 + 1;
        }

        for (int i = 0; i < arr1.length; i++) {     //数组长度是5，索引范围：[0,length-1]
            System.out.println(arr1[i]);
        }


    }

}
