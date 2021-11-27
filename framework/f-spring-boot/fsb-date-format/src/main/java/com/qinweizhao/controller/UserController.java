package com.qinweizhao.controller;


import com.qinweizhao.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author qinweizhao
 * @since 2021/11/20
 */
@RestController
public class UserController {
    @GetMapping("/")
    public User get() {
        return new User("1", "socks", "123456", new Date(), "GMT");
    }
}


