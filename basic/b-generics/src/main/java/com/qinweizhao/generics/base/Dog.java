package com.qinweizhao.generics.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author qinweizhao
 * @since 2021-12-29
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Dog extends Animal{


    @Override
    public int countLegs() {
        return 4;
    }
}
