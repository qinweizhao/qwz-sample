package com.qinweizhao.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * list 集合去除 null
 *
 * @author qinweizhao
 * @since 2021-11-18
 */
public class RemoveNullMain {

    private RemoveNullMain() {
    }

    public static List<Object> removeNullOne(List<Object> oldList) {
        oldList.removeAll(Collections.singleton(null));
        return oldList;
    }

    public static List<Object> removeNullTwo(List<Object> oldList) {
        // 临时集合
        List<Object> listTemp = new ArrayList<>();
        for (Object t : oldList) {
            // 保存不为空的元素
            if (t != null) {
                listTemp.add(t);
            }
        }
        return listTemp;
    }


    public static List<Object> removeNullThree(List<Object> oldList) {
        List<Object> nullList = new ArrayList<>();
        nullList.add(null);
        oldList.removeAll(nullList);
        return oldList;
    }

}
