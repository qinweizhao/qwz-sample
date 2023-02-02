package com.qinweizhao.basic.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 发送消息线程
 */
class Send1 extends Thread {
    private Socket socket;
    private Scanner scanner;

    public Send1(Socket socket, Scanner scanner) {
        this.socket = socket;
        this.scanner = scanner;
    }

    @Override
    public void run() {
        this.sendMsg();
    }

    /**
     * 发送消息
     */
    private void sendMsg() {

        PrintWriter pw = null;
        try {
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
 * 接收消息的线程
 */
class Receive1 extends Thread {
    private Socket socket;

    public Receive1(Socket socket) {
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

public class GoodTCP {
    public static void main(String[] args) {
        Scanner scanner = null;
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            scanner = new Scanner(System.in);
            System.out.println("请输入：server,<port> 或者：<ip>,<port>");
            String str = scanner.nextLine();
            String[] arr = str.split(",");
            if ("server".equals(arr[0])) {
                //启动服务端
                System.out.println("TCP Server Listen at " + arr[1] + " .....");
                serverSocket = new ServerSocket(Integer.parseInt(arr[1]));
                socket = serverSocket.accept();
                System.out.println("连接成功！");

            } else {
                //启动客户端
                socket = new Socket(arr[0], Integer.parseInt(arr[1]));
                System.out.println("连接成功！");
            }
            //启动发送消息的线程
            new Send1(socket, scanner).start();
            //启动接收消息的线程
            new Receive1(socket).start();
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
