package com.qinweizhao.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DSDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DSDiscoveryApplication.class, args);
    }

}
