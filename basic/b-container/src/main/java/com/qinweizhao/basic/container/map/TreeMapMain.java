package com.qinweizhao.basic.container.map;


import com.qinweizhao.basic.container.common.Student;
import com.qinweizhao.basic.container.common.Users;
import com.qinweizhao.basic.container.util.StudentComparatorMain;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author qinweizhao
 * @since 2021-11-26
 */
public class TreeMapMain {
    public static void main(String[] args) {
        //实例化TreeMap
        Map<Users, String> map = new TreeMap<>();
        Users u1 = new Users("oldlu", 18);
        Users u2 = new Users("admin", 22);
        Users u3 = new Users("c", 22);
        map.put(u1, "oldlu");
        map.put(u2, "admin");
        map.put(u3, "c");
        Set<Users> keys = map.keySet();
        for (Users key : keys) {
            System.out.println(key + " --------- " + map.get(key));
        }
        System.out.println("---------------------------");
        Map<Student, String> treeMap = new TreeMap<>(new StudentComparatorMain());
        Student s1 = new Student("oldlu", 18);
        Student s2 = new Student("admin", 22);
        Student s3 = new Student("c", 22);
        treeMap.put(s1, "oldlu");
        treeMap.put(s2, "admin");
        treeMap.put(s3, "c");
        Set<Student> keys1 = treeMap.keySet();
        for (Student key : keys1) {
            System.out.println(key + " ---- " + treeMap.get(key));
        }
    }
}
