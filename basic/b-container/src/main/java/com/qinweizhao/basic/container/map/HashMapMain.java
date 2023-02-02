package com.qinweizhao.basic.container.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author qinweizhao
 * @since 2021-11-26
 */
public class HashMapMain {
    public static void main(String[] args) {
        //实例化HashMap容器
        Map<String, String> map = new HashMap<>();
        //添加元素
        map.put("a", "A");
        String value = map.put("a", "B");
        System.out.println(value);

        System.out.println("---------------------------");
        String val = map.get("a");
        System.out.println(val);

        System.out.println("------------------------------");
        map.put("b", "B");
        map.put("c", "C");
        map.put("d", "D");
        map.put("e", "E");
        //获取HashMap容器中所有的元素，可以使用keySet方法与get方法一并完成。
        Set<String> keys = map.keySet();
        for (String key : keys) {
            String v1 = map.get(key);
            System.out.println(key + " ---- " + v1);
        }
        System.out.println("-----------------");
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            String key = entry.getKey();
            String v = entry.getValue();
            System.out.println(key + " ---------- " + v);
        }

        System.out.println("-----------------------");
        Map<String, String> map2 = new HashMap<>();
        map2.put("f", "F");
        map2.put("c", "cc");
        map2.putAll(map);
        Set<String> keys2 = map2.keySet();
        for (String key : keys2) {
            System.out.println("key: " + key + " Value: " + map2.get(key));
        }

        System.out.println("-----------------------");
        String v = map.remove("e");
        System.out.println(v);
        Set<String> keys3 = map.keySet();
        for (String key : keys3) {
            System.out.println("key: " + key + " Value: " + map.get(key));
        }

        System.out.println("---------------------------");
        boolean flag = map.containsKey("a");
        System.out.println(flag);
        System.out.println("------------------------");
        boolean flag2 = map.containsValue("B");
        System.out.println(flag2);
    }
}
