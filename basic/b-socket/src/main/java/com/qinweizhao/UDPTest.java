package com.qinweizhao;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPTest {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        try {
            //创建服务端接收数据的DatagramSocket对象
            datagramSocket = new DatagramSocket(9999);
            //创建数据缓存区
            byte[] b = new byte[1024];
            //创建数据报包对象
            DatagramPacket dp = new DatagramPacket(b, b.length);
            //等待接收客户端所发送的数据
            datagramSocket.receive(dp);
            String str = new String(dp.getData(), 0, dp.getLength());
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        }
    }
}
