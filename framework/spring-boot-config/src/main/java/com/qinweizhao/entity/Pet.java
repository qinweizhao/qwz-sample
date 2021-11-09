package com.qinweizhao.entity;


import lombok.Data;

/**
 * @author qinweizhao
 * @since 2021/9/17
 */
@Data
public class Pet {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
