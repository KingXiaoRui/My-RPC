package com.king.demo.rpc;

/**
 * @author King Chen
 * @Date: 2019/3/20 20:31
 */
public class HelloWorldServiceImpl implements IHelloWorldService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
