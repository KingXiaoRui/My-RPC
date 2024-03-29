package com.king.demo.rpc.client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author King Chen
 * @Date: 2019/3/21 22:55
 */
public class RemoteInvocationHandler implements InvocationHandler {
    private String host;
    private int port;

    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest request = new RpcRequest();
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setParameters(args);

        TCPTransport tcpTransport = new TCPTransport(this.host, this.port);

        return tcpTransport.send(request);
    }
}
