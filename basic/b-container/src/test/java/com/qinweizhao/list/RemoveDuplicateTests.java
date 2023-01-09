package com.qinweizhao.list;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qinweizhao
 * @since 2021-11-21
 */
class RemoveDuplicateTests {


    private final List<String> list = new ArrayList<>(Arrays.asList("1", "1", "2", "3", "3", "3", "4", "5", "6", "6", "6", "7", "8"));


    @Test
    void removeDuplicateOne() {

        RemoveDuplicateMain.removeDuplicateOne(list);
    }


    @Test
    void removeDuplicateTwo() {
        RemoveDuplicateMain.removeDuplicateTwo(list);
    }


    @Test
    void removeDuplicateThree() {
        RemoveDuplicateMain.removeDuplicateThree(list);
    }


    @Test
    void removeDuplicateFour() {
        RemoveDuplicateMain.removeDuplicateFour(list);
    }


    @Test
    void removeDuplicateFive() {
        RemoveDuplicateMain.removeDuplicateFive(list);
    }

}
