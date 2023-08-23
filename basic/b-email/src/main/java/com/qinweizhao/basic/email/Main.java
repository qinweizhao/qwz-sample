package com.qinweizhao.basic.email;

import com.qinweizhao.basic.email.util.ExchangeMailUtils;

/**
 * @author qinweizhao
 * @since 2023-07-05
 */
public class Main {
    public static void main(String[] args) throws Exception {
        ExchangeMailUtils exchangeMailUtils = new ExchangeMailUtils("https://win-9jmqd5n590n.test.com/EWS/Exchange.asmx", "Administrator@test.com", "ZTW@6688", null);
        String[] a = {"qwz@test.com"};
        String[] cc = {};
        exchangeMailUtils.send("主题", a, null, "本体");
        System.out.println("发送成功");
    }


}