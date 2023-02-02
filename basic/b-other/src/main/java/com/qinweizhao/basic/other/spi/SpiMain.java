package com.qinweizhao.basic.other.spi;

import com.qinweizhao.basic.other.spi.service.Animal;
import com.qinweizhao.basic.other.spi.service.impl.Cat;

import java.util.ServiceLoader;

/**
 * @author qinweizhao
 * @since 2022-10-19
 */
public class SpiMain {

    public static void main(String[] args) {

        ServiceLoader<Animal> load = ServiceLoader.load(Animal.class);
        for (Animal next : load) {
            if (next instanceof Cat) {
                System.out.println(next);
            }
            System.out.println(next.getName());
        }
    }

}
