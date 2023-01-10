package com.qinweizhao.map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qinweizhao
 * @since 2021/11/19
 */
class MapTest {

    @Test
    void test1() {
        Map<String, String> map = new HashMap<>();

        map.put("a", "this-is-a");
        String a = map.get("a");

        System.out.println(a);

        String replace = a.replace("-", "");
        map.put("a", replace);

        System.out.println(map);
        System.out.println(a);
        System.out.println(map.get("a"));
    }
}
