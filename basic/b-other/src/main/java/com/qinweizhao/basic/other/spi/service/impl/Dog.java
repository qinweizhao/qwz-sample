package com.qinweizhao.basic.other.spi.service.impl;

import com.qinweizhao.basic.other.spi.service.Animal;

/**
 * @author qinweizhao
 * @since 2022-10-19
 */
public class Dog implements Animal {


    @Override
    public String getName() {
        return "Dog";
    }

}
