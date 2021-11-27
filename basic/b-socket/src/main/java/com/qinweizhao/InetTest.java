package com.qinweizhao;

import java.net.InetAddress;

public class InetTest {
    public static void main(String[] args) throws Exception {
        //实例化InetAddress对象
        InetAddress inetAddress = InetAddress.getLocalHost();
        //返回当前计算机的IP地址
        System.out.println(inetAddress.getHostAddress());
        //返回当前计算机名
        System.out.println(inetAddress.getHostName());
    }
}
