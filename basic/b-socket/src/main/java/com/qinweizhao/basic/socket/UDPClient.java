package com.qinweizhao.basic.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPClient {
    public static void main(String[] args) {
        DatagramSocket ds = null;
        try {
            //消息需要进行类型转换，转换成字节数据类型。
            byte[] b = "北京尚学堂".getBytes();

            //创建数据报包装对象DatagramPacket
            DatagramPacket dp = new DatagramPacket(b, b.length, new InetSocketAddress("127.0.0.1", 9999));
            //创建数据发送对象 DatagramSocket,需要指定消息的发送端口
            ds = new DatagramSocket(8888);
            //发送消息
            ds.send(dp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ds != null) {
                ds.close();
            }
        }
    }
}
