package com.qinweizhao.basic.container.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author qinweizhao
 * @since 2021-11-26
 */
public class IteratorListMain {
    public static void main(String[] args) {
        //实例化容器
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        //获取元素
        //获取迭代器对象
        Iterator<String> iterator = list.iterator();
        //方式一:在迭代器中，通过while循环获取元素
        while (iterator.hasNext()) {
            String value = iterator.next();
            System.out.println(value);
        }
        System.out.println("-------------------------------");
        //方法二：在迭代器中，通过for循环获取元素
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            String value = it.next();
            System.out.println(value);
        }

    }
}
