package com.qinweizhao.basic.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class BasicSocketServer {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader br = null;
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("服务器启动监听等待连接。。。。");
            //开启端口的监听
            socket = serverSocket.accept();
            //读取客户端发送的消息
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
