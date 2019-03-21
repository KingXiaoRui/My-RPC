package com.king.demo.rpc;

import com.king.demo.rpc.client.RpcClientProxy;

/**
 * @author King Chen
 * @Date: 2019/3/21 23:20
 */
public class ClientDemo {
    public static void main(String[] args) {
        RpcClientProxy rpcClientProxy = new RpcClientProxy();
        IHelloWorldService service = rpcClientProxy.clientProxy(IHelloWorldService.class, "localhost", 8888);

        System.out.println(service.sayHello("King"));
    }
}
