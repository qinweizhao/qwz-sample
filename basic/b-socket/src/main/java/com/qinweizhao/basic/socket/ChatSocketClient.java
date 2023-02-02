package com.qinweizhao.basic.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 用于发送消息的线程类
 */
class ClientSend extends Thread {
    private Socket socket;

    public ClientSend(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        this.sendMsg();
    }

    /**
     * 发送消息
     */
    private void sendMsg() {
        Scanner scanner = null;
        PrintWriter pw = null;
        try {
            //创建Scanner对象
            scanner = new Scanner(System.in);
            //创建向对方输出消息的流对象
            pw = new PrintWriter(this.socket.getOutputStream());
            while (true) {
                String msg = scanner.nextLine();
                pw.println(msg);
                pw.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
            if (pw != null) {
                pw.close();
            }
            if (this.socket != null) {
                try {
                    this.socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/**
 * 用于接收消息的线程类
 */
class ClientReceive extends Thread {
    private Socket socket;

    public ClientReceive(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        this.receiveMsg();
    }

    /**
     * 用于接收对方消息的方法
     */
    private void receiveMsg() {
        BufferedReader br = null;
        try {
            //创建用于接收对方发送消息的流对象
            br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            while (true) {
                String msg = br.readLine();
                System.out.println("他说：" + msg);
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
        }
    }
}

public class ChatSocketClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            System.out.println("连接成功！");
            new ClientSend(socket).start();
            new ClientReceive(socket).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
