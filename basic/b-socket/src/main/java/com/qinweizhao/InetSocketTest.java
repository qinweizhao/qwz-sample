package com.qinweizhao;

import java.net.InetSocketAddress;

public class InetSocketTest {
    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("www.baidu.com", 80);
        System.out.println(inetSocketAddress.getAddress().getHostAddress());
        System.out.println(inetSocketAddress.getHostName());
    }
}
