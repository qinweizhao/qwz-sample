package com.qinweizhao.sample.fsb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author qinweizhao
 * @since 2022-12-30
 */
@Controller
public class TestController {


    @RequestMapping("test-error")
    public void testError() {
        int a = 1 / 0;
        System.out.println(a);
    }
}
