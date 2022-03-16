package com.qinweizhao.service.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qinweizhao
 * @since 2022/3/15
 */
@RestController
@RequestMapping("/service")
public class ServiceController {


    @GetMapping("/a")
    public String a(){
        return "这是 Service 服务返回的信息";
    }
}
