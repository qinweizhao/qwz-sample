package com.qinweizhao;

import java.net.InetAddress;

public class InetTest2 {
    public static void main(String[] args) throws Exception {
        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress.getHostAddress());
        System.out.println(inetAddress.getHostName());
    }
}
