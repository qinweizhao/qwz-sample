package com.qinweizhao.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author weizhao
 */
public class Test {


    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>(2);

        AA aa = new AA();
        Integer integer12 = aa.getInteger1();
        Optional<Integer> integer11 = Optional.ofNullable(aa.getInteger1());
        Integer integer1 = integer11.orElse(1);
        map.put("cache", integer1);
        Integer integer = map.get("cache");
        AtomicInteger ai = new AtomicInteger(integer);
        System.out.println(ai.get());

    }


    public static class AA {
        private Integer integer1;

        public Integer getInteger1() {
            return integer1;
        }

        public void setInteger1(Integer integer1) {
            this.integer1 = integer1;
        }
    }


}
