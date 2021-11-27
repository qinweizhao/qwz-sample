package com.qinweizhao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class ObjectTypeClient {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        try {
            Person p = new Person();
            p.setName("Oldlu");
            p.setAge(18);

            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(p);
            byte[] arr = bos.toByteArray();

            DatagramPacket dp = new DatagramPacket(arr, arr.length, new InetSocketAddress("127.0.0.1", 9999));
            datagramSocket = new DatagramSocket(8888);
            datagramSocket.send(dp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null) {
                datagramSocket.close();
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
