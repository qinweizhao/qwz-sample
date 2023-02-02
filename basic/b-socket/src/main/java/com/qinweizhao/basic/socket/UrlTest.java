package com.qinweizhao.basic.socket;

import java.net.URL;

public class UrlTest {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.baidu.com/s?ie=utf-8&f=3&rsv_bp=1&rsv_idx=1&tn=baidu&wd=itbz");
        System.out.println("获取与此URL相关联协议的默认端口：" + url.getDefaultPort());
        System.out.println("访问资源：" + url.getFile());
        System.out.println("主机名" + url.getHost());
        System.out.println("访问资源路径：" + url.getPath());
        System.out.println("协议：" + url.getProtocol());
        System.out.println("参数部分：" + url.getQuery());
    }
}
