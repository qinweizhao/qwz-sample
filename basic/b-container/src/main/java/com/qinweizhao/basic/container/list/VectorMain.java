package com.qinweizhao.basic.container.list;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * @author qinweizhao
 * @since 2021-11-26
 */
public class VectorMain {
    public static void main(String[] args) {

        //实例化Vector
        List<String> v = new Vector<>();
        v.add("a");
        v.add("b");
        v.add("a");

        for (int i = 0; i < v.size(); i++) {
            System.out.println(v.get(i));
        }
        System.out.println("----------------------");
        for (String str : v) {
            System.out.println(str);
        }
        LinkedList list = new LinkedList();
    }
}
