package com.qinweizhao.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author qinweizhao
 * @since 2021/11/26
 */
public class IteratorSetMain {
    public static void main(String[] args) {
        //实例化Set类型的容器
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        //方式一：通过while循环
        //获取迭代器对象
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            System.out.println(value);
        }
        System.out.println("-------------------------");
        //方式二：通过for循环
        for (Iterator<String> it = set.iterator(); it.hasNext(); ) {
            String value = it.next();
            System.out.println(value);
        }
    }
}
