package com.qinweizhao.list;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author qinweizhao
 * @since 2021/11/26
 */
class ArrayListMainTest {


    /**
     * 通过指定索引位置获取元素
     */
    @Test
    void getOne() {
        List<String> list = ArrayListMain.init();
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println("---------------");
    }

    /**
     * 通过循环获取集合中所用元素
     * size():返回集合中元素个数
     */
    void getTwo() {
        List<String> list = ArrayListMain.init();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * 根据索引位置删除元素
     */
    void removeOne() {
        List<String> list = ArrayListMain.init();
        String value = list.remove(1);
        System.out.println(value);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * 删除指定元素
     */
    void removeTwo() {
        List<String> list = ArrayListMain.init();
        boolean flag3 = list.remove("a");
        System.out.println(flag3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * 替换元素
     */
    void replace() {
        List<String> list = ArrayListMain.init();
        String val = list.set(0, "a");
        System.out.println(val);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * 清空容器
     */
    void clear() {
        List<String> list = ArrayListMain.init();
        list.clear();
        System.out.println(list.size());
    }

    /**
     * 判断容器是否为空
     */
    void isEmpty() {
        List<String> list = ArrayListMain.init();
        list.add("b");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("old");
        list.add("a");
        //如果容器为空则返回true，否则返回false
        System.out.println(list.isEmpty());
    }

    /**
     * 判断容器中是否包含指定元素
     */
    void contains() {
        List<String> list = ArrayListMain.init();
        //如果在容器中包含指定元素则返回true，否则返回false。
        boolean flag5 = list.contains("old");
        System.out.println(flag5);
    }

}