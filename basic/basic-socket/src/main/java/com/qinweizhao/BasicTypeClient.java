package com.qinweizhao;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class BasicTypeClient {
    public static void main(String[] args) {
        long n = 2000L;
        ByteArrayOutputStream bos = null;
        DataOutputStream dos = null;
        DatagramSocket datagramSocket = null;
        try {
            bos = new ByteArrayOutputStream();
            dos = new DataOutputStream(bos);
            dos.writeLong(n);
            //将基本数据类型数据转换成字节数组类型
            byte[] arr = bos.toByteArray();
            DatagramPacket dp = new DatagramPacket(arr, arr.length, new InetSocketAddress("127.0.0.1", 9999));
            datagramSocket = new DatagramSocket(9000);
            datagramSocket.send(dp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        }
    }
}
