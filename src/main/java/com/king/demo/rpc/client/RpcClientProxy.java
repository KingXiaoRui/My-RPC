package com.king.demo.rpc.client;

import java.lang.reflect.Proxy;

/**
 * @author King Chen
 * @Date: 2019/3/21 22:54
 */
public class RpcClientProxy {

    public <T> T clientProxy(final Class<T> interfaceCls, final String host, final int port) {

        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(), new Class[]{interfaceCls}, new RemoteInvocationHandler(host , port));
    }
}
