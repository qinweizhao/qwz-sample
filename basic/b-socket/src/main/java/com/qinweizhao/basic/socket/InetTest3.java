package com.qinweizhao.basic.socket;

import java.net.InetAddress;

public class InetTest3 {
    public static void main(String[] args) throws Exception {
        InetAddress inetAddress = InetAddress.getByName("39.156.66.14");
        System.out.println(inetAddress.getHostAddress());
        System.out.println(inetAddress.getHostName());
    }
}
