package com.king.demo.rpc.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author King Chen
 * @Date: 2019/3/21 22:57
 */
public class TCPTransport {
    private String host;
    private int port;

    public TCPTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    private Socket newSocket() {
        System.out.println("创建一个新的连接");
        Socket socket;
        try {
            socket = new Socket(host, port);
            return socket;
        } catch (Exception e) {
            throw new RuntimeException("连接建立失败");
        }
    }

    public Object send(RpcRequest request) {
        Socket socket = null;
        try {
            socket = newSocket();
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(request);
            outputStream.flush();

            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            Object result = inputStream.readObject();
            inputStream.close();
            outputStream.close();

            return result;

        } catch (Exception e) {
            throw new RuntimeException("", e);
        } finally {
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
