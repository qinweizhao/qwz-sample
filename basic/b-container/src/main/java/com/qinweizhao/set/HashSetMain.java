package com.qinweizhao.set;

import com.qinweizhao.common.Users;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qinweizhao
 * @since 2021/11/26
 */
public class HashSetMain {
    public static void main(String[] args) {
        //实例化HashSet
        Set<String> set = new HashSet<>();
        //添加元素
        set.add("a");
        set.add("b1");
        set.add("c2");
        set.add("d");
        set.add("a");
        //获取元素,在Set容器中没有索引，所以没有对应的get(int index)方法
        for (String str : set) {
            System.out.println(str);
        }
        System.out.println("--------------------");
        //删除元素
        boolean flag = set.remove("c2");
        System.out.println(flag);
        for (String str : set) {
            System.out.println(str);
        }
        System.out.println("------------------------");
        int size = set.size();
        System.out.println(size);

        System.out.println("----------------------------");
        //实例化HashSet
        Set<Users> set1 = new HashSet<>();
        Users u = new Users("oldlu", 18);
        Users u1 = new Users("oldlu", 18);
        set1.add(u);
        set1.add(u1);
        System.out.println(u.hashCode());
        System.out.println(u1.hashCode());
        for (Users users : set1) {
            System.out.println(users);
        }
    }
}
