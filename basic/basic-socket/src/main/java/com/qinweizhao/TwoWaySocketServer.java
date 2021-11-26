package com.qinweizhao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TwoWaySocketServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        BufferedReader br = null;
        Scanner scanner = null;
        PrintWriter pw = null;
        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("服务端启动！监听端口8888。。。。");
            socket = serverSocket.accept();
            //创建从客户端读取消息的流对象
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //创建键盘输入对象
            scanner = new Scanner(System.in);
            //创建向客户端发送消息的输出流对象
            pw = new PrintWriter(socket.getOutputStream());
            while (true) {
                //读取客户端发送的消息
                String str = br.readLine();
                System.out.println("客户端说：" + str);
                String keyInput = scanner.nextLine();
                //发送到客户端
                pw.println(keyInput);
                pw.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
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
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (scanner != null) {
                scanner.close();
            }
            if (pw != null) {
                pw.close();
            }
        }
    }
}
