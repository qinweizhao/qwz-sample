package com.qinweizhao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 接收客户端消息的线程类
 */
class ChatReceive extends Thread {
    private Socket socket;

    public ChatReceive(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        this.receiveMsg();
    }

    /**
     * 实现接收客户端发送的消息
     */
    private void receiveMsg() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            while (true) {
                String msg = br.readLine();
                synchronized ("abc") {
                    //把读取到的数据写入公共数据区
                    ChatRoomServer.buf = "[" + this.socket.getInetAddress() + "] " + msg;
                    //唤醒发送消息的线程对象。
                    "abc".notifyAll();
                }
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
 * 向客户端发送消息的线程类
 */
class ChatSend extends Thread {
    private Socket socket;

    public ChatSend(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        this.sendMsg();
    }

    /**
     * 将公共数据区的消息发送给客户端
     */
    private void sendMsg() {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(this.socket.getOutputStream());
            while (true) {
                synchronized ("abc") {
                    //让发送消息的线程处于等待状态
                    "abc".wait();
                    //将公共数据区中的消息发送给客户端
                    pw.println(ChatRoomServer.buf);
                    pw.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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

public class ChatRoomServer {
    //定义公共数据区
    public static String buf;

    public static void main(String[] args) {
        System.out.println("Chat Server Version 1.0");
        System.out.println("Listen at 8888.....");
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8888);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("连接到：" + socket.getInetAddress());
                new ChatReceive(socket).start();
                new ChatSend(socket).start();
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
        }
    }
}
