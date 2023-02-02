package com.qinweizhao.basic.other.spi.service.impl;

import com.qinweizhao.basic.other.spi.service.Animal;

/**
 * @author qinweizhao
 * @since 2022-10-19
 */
public class Cat implements Animal {

    private final Dog dog = new Dog();

    @Override
    public String getName() {
        return "Cat";
    }

    public String sum() {
        return "Cat" + dog.getName();
    }

    @Override
    public String toString() {
        return "Cat{" +
                "dog=" + dog.getName() +
                '}';
    }
}
