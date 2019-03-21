package com.king.demo.rpc;

import com.king.demo.rpc.server.RpcServer;

/**
 * @author King Chen
 * @Date: 2019/3/21 23:18
 */
public class ServerDemo {
    public static void main(String[] args) {
        IHelloWorldService service = new HelloWorldServiceImpl();

        RpcServer rpcServer = new RpcServer();
        rpcServer.publisher(service, 8888);
    }
}
