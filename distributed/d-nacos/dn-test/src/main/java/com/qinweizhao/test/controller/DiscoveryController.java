package com.qinweizhao.test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author weizhao
 */
@RestController
public class DiscoveryController {


    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/{id}")
    public String testDiscovery(){
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://service/discovery/101", String.class);
        return forEntity.getBody();
    }

}
