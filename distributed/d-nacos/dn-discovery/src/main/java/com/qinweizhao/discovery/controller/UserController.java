package com.qinweizhao.discovery.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * (tb_order)表控制层
 *
 * @author xxxxx
 */
@RestController
@RequestMapping("/order")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public Object selectOne(@PathVariable("id") Integer id) {
        String url = "http://user-service/user/101";
        return url;
    }

}
