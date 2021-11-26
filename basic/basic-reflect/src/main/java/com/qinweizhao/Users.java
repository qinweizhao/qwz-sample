package com.qinweizhao;

import java.io.Serializable;
import java.util.ArrayList;

public class Users extends ArrayList implements Serializable {
    public int userage;
    private String username;

    public Users() {
    }

    public Users(String username, int userage) {
        this.username = username;
        this.userage = userage;
    }

    public Users(String username) {
        this.username = username;
    }

    private Users(int userage) {
        this.userage = userage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserage() {
        return userage;
    }

    public void setUserage(int userage) {
        this.userage = userage;
    }

    private void suibian() {
        System.out.println("Hello Oldlu");
    }
}
