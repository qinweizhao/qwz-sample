package com.qinweizhao.config.controller;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/{id}")
    public String testDiscovery(@PathVariable String id) {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://dn-discovery/discovery/" + id, String.class);
        return forEntity.getBody() + id;
    }

}
