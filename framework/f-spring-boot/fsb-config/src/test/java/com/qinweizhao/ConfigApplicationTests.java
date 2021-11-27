package com.qinweizhao;

import com.qinweizhao.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConfigApplicationTests {

    @Autowired
    Person person;

    @Test
    void contextLoads() {

    }
    /**
     * 配置文件值注入( @ConfigurationProperties 方式)
     */
    @Test
    void test2() {
        System.out.println(person);
    }

    /**
     * 指定配置文件值注入
     * 需要 @PropertySource 注解，如果配置文件不是 application 则需要指定注解的 factory 属性
     */
    @Test
    void test3() {
        System.out.println(person);
    }


    /**
     * 配置文件校验
     * 1.
     * <dependency>
     * <groupId>org.springframework.boot</groupId>
     * <artifactId>spring-boot-starter-validation</artifactId>
     * </dependency>
     * 2.类上标注 @Validated ，在实体类上标注注解 @Email
     */
    @Test
    void test4() {
        System.out.println(person);
    }

}
