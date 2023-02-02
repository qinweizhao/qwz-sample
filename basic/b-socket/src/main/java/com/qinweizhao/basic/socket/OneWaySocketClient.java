package com.qinweizhao.basic.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class OneWaySocketClient {
    public static void main(String[] args) {
        Socket socket = null;
        Scanner scanner = null;
        PrintWriter pw = null;
        BufferedReader br = null;
        try {
            socket = new Socket("127.0.0.1", 8888);
            //创建键盘输入对象
            scanner = new Scanner(System.in);
            //创建向服务端输出消息的流对象
            pw = new PrintWriter(socket.getOutputStream());
            //创建读取服务端返回消息的流对象
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                //通过键盘输入获取需要向服务端发送的消息
                String str = scanner.nextLine();
                //将消息发送到服务端
                pw.println(str);
                pw.flush();
                if ("exit".equals(str)) {
                    break;
                }
                //读取服务端返回的消息
                String serverInput = br.readLine();
                System.out.println("服务端返回的：" + serverInput);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
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
