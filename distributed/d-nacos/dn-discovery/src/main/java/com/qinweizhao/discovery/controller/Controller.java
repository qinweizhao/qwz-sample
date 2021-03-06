package com.qinweizhao.discovery.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制层
 *
 * @author qinweizhao
 */
@RestController
@RequestMapping("/discovery")
public class Controller {

    @GetMapping("/{id}")
    public Object selectOne(@PathVariable("id") Integer id) {
        id += 100;
        return id.toString();
    }

}
