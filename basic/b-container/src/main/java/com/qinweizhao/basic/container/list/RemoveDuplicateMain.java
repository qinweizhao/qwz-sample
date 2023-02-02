package com.qinweizhao.basic.container.list;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author qinweizhao
 * @since 2021-11-21
 */
public class RemoveDuplicateMain {

    private RemoveDuplicateMain() {
    }

    /**
     * LinkedHashSet 删除 arraylist 中的重复数据
     *
     * @param list list
     */
    public static void removeDuplicateOne(List<String> list) {
        LinkedHashSet<String> hashSet = new LinkedHashSet<>(list);
        ArrayList<String> listWithoutDuplicates = new ArrayList<>(hashSet);
        System.out.println(listWithoutDuplicates);
    }


    /**
     * stream 进行 List 去重
     *
     * @param list list
     */
    public static void removeDuplicateTwo(List<String> list) {
        List<String> listWithoutDuplicates = list.stream().distinct().collect(Collectors.toList());
        System.out.println(listWithoutDuplicates);
    }

    /**
     * 利用 HashSet 不能添加重复数据的特性 由于 HashSet 不能保证添加顺序，所以只能作为判断条件保证顺序
     *
     * @param list list
     */
    public static void removeDuplicateThree(List<String> list) {
        HashSet<String> set = new HashSet<>(list.size());
        List<String> result = new ArrayList<>(list.size());
        for (String str : list) {
            if (set.add(str)) {
                result.add(str);
            }
        }
        list.clear();
        list.addAll(result);
    }

    /**
     * 利用 List 的 contains 方法循环遍历, 重新排序, 只添加一次数据, 避免重复
     *
     * @param list list
     */
    public static void removeDuplicateFour(List<String> list) {
        List<String> result = new ArrayList<>(list.size());
        for (String str : list) {
            if (!result.contains(str)) {
                result.add(str);
            }
        }
        list.clear();
        list.addAll(result);
    }

    /**
     * 双重 for 循环去重
     *
     * @param list list
     */
    public static void removeDuplicateFive(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j && Objects.equals(list.get(i), list.get(j))) {
                    list.remove(list.get(j));
                }
            }
        }
    }
}
