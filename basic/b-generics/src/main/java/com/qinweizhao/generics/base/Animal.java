package com.qinweizhao.generics.base;

import lombok.Data;

/**
 * @author qinweizhao
 * @since 2021-12-29
 */
@Data
public abstract class Animal {
    private Integer leg;

    /**
     * 动物有几条退
     *
     * @return int
     */
    public abstract int countLegs();
}
