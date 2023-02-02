package com.qinweizhao.basic.container.summary.traversal;

import java.util.*;

/**
 * @author qinweizhao
 * @since 2022/2/14
 */
public class Traversal {

    // List

    public void list() {
        //实例化容器
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        // 1、普通 for 循环
        for (int i = 0; i < list.size(); i++) {
            String temp = list.get(i);
            System.out.println(temp);
        }

        // 2、增强 for 循环（使用泛型！）
        for (String temp : list) {
            System.out.println(temp);
        }

        // 3、使用 Iterator 迭代器(1)
        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
            String temp = (String) iter.next();
            System.out.println(temp);
        }

        // 4、使用 Iterator 迭代器(2)
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object obj = iter.next();
            iter.remove();//如果要遍历时，删除集合中的元素，建议使用这种方式！
            System.out.println(obj);
        }
    }

    // Set

    public void set() {
        //实例化容器
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");

        // 1、增强 for 循环
        for (String temp : set) {
            System.out.println(temp);
        }

        // 2、使用Iterator迭代器
        for (Iterator iter = set.iterator(); iter.hasNext(); ) {
            String temp = (String) iter.next();
            System.out.println(temp);
        }
    }


    // Map
    public void map() {

        Map<Integer, Object> maps = new HashMap<>();
        maps.put(1, "a");
        maps.put(2, "b");
        maps.put(3, "c");
        maps.put(4, "d");


        // 1、根据 key 获取 value
        Set<Integer> keySet = maps.keySet();
        for (Integer id : keySet) {
            System.out.println(maps.get(id));
        }

        // 2、使用 entrySet
        Set<Map.Entry<Integer, Object>> ss = maps.entrySet();
        for (Map.Entry<Integer, Object> s : ss) {
            Map.Entry e = s;
            System.out.println(e.getKey() + "--" + e.getValue());
        }
    }
}
