package com.qinweizhao.basic.io.demo;

import java.io.Serializable;

/**
 * @author qinweizhao
 * @since 2021-11-26
 */
public class Users implements Serializable {
    private int userid;
    private String username;
    private String userage;

    public Users(int userid, String username, String userage) {
        this.userid = userid;
        this.username = username;
        this.userage = userage;
    }

    public Users() {
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserage() {
        return userage;
    }

    public void setUserage(String userage) {
        this.userage = userage;
    }
}
