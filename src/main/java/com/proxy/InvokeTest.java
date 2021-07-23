package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class InvokeTest {

    public static void main(String[] args) {
        //创建实现对象类
        MaotaiJiu maotaiJiu = new MaotaiJiu();
        //创建经销商，进行销售
        InvocationHandler jingxiao1 = new GuitaiA(maotaiJiu);
        //动态代理
        Market market = (Market) Proxy.newProxyInstance(MaotaiJiu.class.getClassLoader(),
                MaotaiJiu.class.getInterfaces(), jingxiao1);

        //通过代理对象进行卖酒
        market.maiJiu();
    }

}
