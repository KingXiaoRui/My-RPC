package com.king.demo.rpc.client;

import java.io.Serializable;

/**
 * @author King Chen
 * @Date: 2019/3/21 22:53
 */
public class RpcRequest implements Serializable {
    private static final long serialVersionUID = -7137108866603476539L;
    private String className;
    private String methodName;
    private Object[] parameters;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
