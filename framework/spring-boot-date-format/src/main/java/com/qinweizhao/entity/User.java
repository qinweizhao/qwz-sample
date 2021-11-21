package com.qinweizhao.entity;

/**
 * @author qinweizhao
 * @since 2021/11/20
 */

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author qinweizhao
 * @since 2021/11/20
 */
@Data
@NoArgsConstructor
public class User {

    private String userId;
    private String username;
    private String password;
    private Date createTime;
    private String timezone;

    public User(String userId, String username, String password, Date createTime, String timezone) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.createTime = createTime;
        this.timezone = timezone;
    }

    //省略getters&setters
}