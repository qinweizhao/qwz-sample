package com.qinweizhao.list;

import java.util.LinkedList;
import java.util.List;

/**
 * @author qinweizhao
 * @since 2021-11-26
 */
public class LinkedListMain {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        //添加元素
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("a");
        list.add(2, "aaaa");
        list.remove(2);
        //获取元素
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("-------------------");
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println("-------LinkedList-------------");
        LinkedList<String> linkedList1 = new LinkedList<>();
        linkedList1.addFirst("a");
        linkedList1.addFirst("b");
        linkedList1.addFirst("c");
        for (String str : linkedList1) {
            System.out.println(str);
        }
        System.out.println("----------------------");
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addLast("a");
        linkedList.addLast("b");
        linkedList.addLast("c");
        for (String str : linkedList) {
            System.out.println(str);
        }
        System.out.println("---------------------------");
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println("-----------------------");
        linkedList.removeFirst();
        linkedList.removeLast();
        for (String str : linkedList) {
            System.out.println(str);
        }
        System.out.println("-----------------------");
        linkedList.addLast("c");
        linkedList.pop();
        for (String str : linkedList) {
            System.out.println(str);
        }
        System.out.println("-------------------");
        linkedList.push("h");
        for (String str : linkedList) {
            System.out.println(str);
        }
        System.out.println(linkedList.isEmpty());
    }
}
