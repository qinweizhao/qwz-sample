package com.qinweizhao.basic.container.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qinweizhao
 * @since 2021-11-26
 */
public class ArrayListMain {


    public static List<String> init() {
        //实例化ArrayList容器
        List<String> list = new ArrayList<>();
        //添加元素
        list.add("a");
        list.add("b");
        //索引的数值不能大于元素的个数。
        list.add(1, "c");
        list.add("d");
        return list;
    }

    public static void main(String[] args) {
        List<String> list = ArrayListMain.init();
        System.out.println("---------查找元素在容器中的位置(索引)--------");
        //indexOf方法返回的是元素在容器中第一次出现的位置。
        //在容器中不存在则返回-1
        int index = list.indexOf("a4");
        System.out.println(index);
        System.out.println("-----------元素最后一次出现的位置--------");
        //lastIndexOf方法返回的是元素在容器中最后一次出现的位置，如果元素
        //在容器中不存在则返回-1
        int lastIndex = list.lastIndexOf("a");
        System.out.println(lastIndex);

        System.out.println("-----将单例集合转换为数组----------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("-----------转换为Object[]-------");
        //将ArrayList转换为Object[]。
        //但是不能将转换的数组做强制类型转换。
        Object[] arr = list.toArray();
        for (int i = 0; i < arr.length; i++) {
            String str = (String) arr[i];
            System.out.println(str);
        }
        System.out.println("---------将单例集合转换为指定类型的数组-----");
        //可以将单例集合转换为指定类型数组。
        //但是。类型需要参考泛型中的类型。
        String[] arr2 = list.toArray(new String[list.size()]);
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }

        System.out.println("------容器的并集操作--------");
        //容器的并集操作
        List<String> a = new ArrayList<>();
        a.add("a");
        a.add("b");
        a.add("c");

        List<String> b = new ArrayList<>();
        b.add("b");
        b.add("c");
        b.add("d");

        //a并b
        boolean flag6 = a.addAll(b);
        System.out.println(flag6);
        for (String str : a) {
            System.out.println(str);
        }
        System.out.println("------容器的交集操作-------");
        //容器的交集操作
        List<String> a1 = new ArrayList<>();
        a1.add("a");
        a1.add("b");
        a1.add("c");

        List<String> b1 = new ArrayList<>();
        b1.add("b");
        b1.add("c");
        b1.add("d");
        boolean flag7 = a1.retainAll(b1);
        System.out.println(flag7);
        for (String str : a1) {
            System.out.println(str);
        }
        System.out.println("------容器的差集操作-------");
        //容器的差集操作
        List<String> a2 = new ArrayList<>();
        a2.add("a");
        a2.add("b");
        a2.add("c");

        List<String> b2 = new ArrayList<>();
        b2.add("b");
        b2.add("c");
        b2.add("d");
        boolean flag8 = a2.removeAll(b2);
        System.out.println(flag8);
        for (String str : a2) {
            System.out.println(str);
        }
    }
}

