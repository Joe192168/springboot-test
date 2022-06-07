package com.joe.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GuitaiA implements InvocationHandler {

    //品牌
    private Object pingPai;

    public GuitaiA(Object pingPai){
        this.pingPai = pingPai;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("销售开始，柜台是："+this.getClass().getSimpleName());
        method.invoke(pingPai,args);
        System.out.println("销售结束");
        return null;
    }
}
