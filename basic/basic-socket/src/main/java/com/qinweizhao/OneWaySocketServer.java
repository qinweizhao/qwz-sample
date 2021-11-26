package com.qinweizhao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class OneWaySocketServer {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("服务端启动，开始监听。。。。。");
            socket = serverSocket.accept();
            System.out.println("连接成功！");
            //读取客户端发送的消息
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //向客户端写回消息的流对象
            pw = new PrintWriter(socket.getOutputStream());
            while (true) {
                String str = br.readLine();
                System.out.println("客户端说：" + str);
                if ("exit".equals(str)) {
                    break;
                }
                pw.println(str);
                pw.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
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
