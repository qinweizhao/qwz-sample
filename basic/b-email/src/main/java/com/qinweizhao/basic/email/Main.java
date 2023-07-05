package com.qinweizhao.basic.email;

import com.qinweizhao.basic.email.util.ExchangeMailUtils;

/**
 * @author qinweizhao
 * @since 2023-07-05
 */
public class Main {
    public static void main(String[] args) throws Exception {
        ExchangeMailUtils exchangeMailUtils = new ExchangeMailUtils("https://webmail.XXXXX.com/EWS/Exchange.asmx", "用户名", "密码", "域");
        String[] a = {"收件人邮箱"};
        String[] cc = {};
        exchangeMailUtils.send("主题", a, null, "本体");
    }


}