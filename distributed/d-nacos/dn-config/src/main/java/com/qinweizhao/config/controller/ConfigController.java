package com.qinweizhao.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qinweizhao
 */
@RestController
//动态刷新
@RefreshScope
public class ConfigController {

    @Value("${test.user.name}")
    private String name;

    @Value("${test.user.age}")
    private String age;

    @GetMapping("info")
    public String get() {
        return name + age;
    }
}