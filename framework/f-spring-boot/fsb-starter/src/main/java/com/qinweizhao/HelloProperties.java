package com.qinweizhao;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author qinweizhao
 * @since 2021-11-29
 */
@ConfigurationProperties(prefix = "qwz")
public class HelloProperties {

    private static final String DEFAULT_NAME="qinweizhao";

    private static final String DEFAULT_AGE="24";

    private String name = DEFAULT_NAME;

    private String age=DEFAULT_AGE;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
