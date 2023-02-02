package com.qinweizhaoq.list;

import com.qinweizhao.basic.container.list.RemoveNullMain;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 移除 list 中的 null
 *
 * @author qinweizhao
 * @since 2021-11-18
 */
class RemoveNullMainTests {


    @Test
    void removeNullOne() {
        List<Object> oldList = new ArrayList<>();
        oldList.add(null);
        oldList.add("1");
        oldList.add(null);
        oldList.add("这个 list 中有两个 null");
        List<Object> objects = RemoveNullMain.removeNullOne(oldList);
        System.out.println(objects);
    }

    @Test
    void removeNullTwo() {
        List<Object> oldList = new ArrayList<>();
        oldList.add(null);
        oldList.add("1");
        oldList.add(null);
        oldList.add("这个 list 中有两个 null");
        List<Object> objects = RemoveNullMain.removeNullTwo(oldList);
        System.out.println(objects);

    }


    @Test
    void removeNullThree() {
        List<Object> oldList = new ArrayList<>();
        oldList.add(null);
        oldList.add("1");
        oldList.add(null);
        oldList.add("这个 list 中有两个 null");
        List<Object> objects = RemoveNullMain.removeNullThree(oldList);
        System.out.println(objects);
    }
}
