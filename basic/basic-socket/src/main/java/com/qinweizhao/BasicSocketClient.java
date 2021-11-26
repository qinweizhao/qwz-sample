package com.qinweizhao;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class BasicSocketClient {
    public static void main(String[] args) {
        Socket socket = null;
        PrintWriter pw = null;
        try {
            //创建Socket对象，两个参数：1，服务端的IP地址，2，服务端所监听的端口
            socket = new Socket("127.0.0.1", 8888);
            pw = new PrintWriter(socket.getOutputStream());
            pw.println("服务端 您好！");
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
