package com.qinweizhao.basic.container.util;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

/**
 * 集合中是否包含某个元素
 *
 * @author qinweizhao
 * @since 2021/12/20
 */
public class ItemContains {

    /**
     * 初始化一个集合
     *
     * @return List<String>
     */
    public static List<String> init() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        return list;
    }


    /**
     * 循环
     *
     * @param list  list
     * @param value value
     * @return return
     */
    public static boolean loop(List<String> list, String value) {
        for (String str : list) {
            if (Objects.equals(str, value)) {
                return true;
            }
        }
        return false;
    }


    /**
     * List.contains判断
     *
     * @param list  list
     * @param value value
     * @return return
     */
    public static boolean listContains(List<String> list, String value) {
        return list.contains(value);
    }


    /**
     * set.contains判断
     *
     * @param list  list
     * @param value value
     * @return return
     */
    public static boolean setContains(List<String> list, String value) {
        Set<String> stringSet = new HashSet<String>(list);
        return stringSet.contains(value);
    }


    /**
     * Arrays.binarySearch判断
     * <p>
     * Arrays.binarySearch()方法只能用于有序数组！！！
     *
     * @param list  list
     * @param value value
     * @return return
     */
    public static boolean arraysBinarySearch(List<String> list, String value) {
        int a = Arrays.binarySearch(list.toArray(), value);
        if (a > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * ArrayUtils.contains判断
     * <p>
     * ArrayUtils 属于 Apache Commons类库 源码也是使用循环判断的方式。
     *
     * @param list  list
     * @param value value
     * @return return
     */
    public static boolean arrayUtils(List<String> list, String value) {
        return ArrayUtils.contains(list.toArray(), value);
    }
}
