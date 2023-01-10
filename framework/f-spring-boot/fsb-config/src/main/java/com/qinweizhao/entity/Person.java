package com.qinweizhao.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;

/**
 * @author qinweizhao
 * @since 2021-09-17
 */

@Component
@Validated
//@PropertySource(value = "classpath:person.yml",factory = YamlPropertySourceFactory.class)
@PropertySource(value = "classpath:person.properties")
@ConfigurationProperties(prefix = "person")
@Data
public class Person {

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 生日
     */
    private Date birth;

    /**
     * 邮箱
     */
    @Email
    private String email;

    /**
     * 朋友
     */
    private List<Object> friend;

}
