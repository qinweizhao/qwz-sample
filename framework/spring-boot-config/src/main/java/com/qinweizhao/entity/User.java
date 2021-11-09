package com.qinweizhao.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;

/**
 * * <bean class="User">
 * *      <property name="name" value="字面量/${key}从环境变量、配置文件中获取值/#{SpEL}"></property>
 * *      <property name="age" value="字面量/${key}从环境变量、配置文件中获取值/#{SpEL}"></property>
 * * <bean/>
 *
 * @author qinweizhao
 * @since 2021/9/17
 */
@Data
@Component
public class User {


    /**
     * 名字
     */
    @Value("${entity.user.name}")
    private String name;

    /**
     * 年龄
     */
    @Value("${entity.user.age}")
    private Integer age;


}
