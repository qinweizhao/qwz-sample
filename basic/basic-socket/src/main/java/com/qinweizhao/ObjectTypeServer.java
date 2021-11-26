package com.qinweizhao;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ObjectTypeServer {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        ObjectInputStream objectInputStream = null;
        try {
            datagramSocket = new DatagramSocket(9999);
            byte[] b = new byte[1024];
            DatagramPacket dp = new DatagramPacket(b, b.length);
            datagramSocket.receive(dp);
            //对接收的内容做类型转换
            objectInputStream = new ObjectInputStream(new ByteArrayInputStream(dp.getData()));
            System.out.println(objectInputStream.readObject());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null) {
                datagramSocket.close();
            }
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
