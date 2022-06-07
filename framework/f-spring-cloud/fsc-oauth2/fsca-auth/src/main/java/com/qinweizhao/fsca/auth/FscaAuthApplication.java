package com.qinweizhao.fsca.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author weizhao
 */
@SpringBootApplication
public class FscaAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(FscaAuthApplication.class, args);
        System.out.println("认证服务器启动成功");
    }

}
