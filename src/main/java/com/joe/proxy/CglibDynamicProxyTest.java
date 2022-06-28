package com.joe.proxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib实现动态代理
 */
public class CglibDynamicProxyTest {

    /**
     * 刘德华实现Person接口，那么他就会唱歌和跳舞了
     */
    static class LiuDeHua {
        public String sing(String name) {
            System.out.println("刘德华唱" + name + "歌！！");
            return "歌曲唱完了，谢谢大家！";
        }
        public String dance(String name) {
            System.out.println("刘德华跳" + name + "舞！！");
            return "舞跳完了，多谢各位观众！";
        }
    }

    /**
     * 这个代理类主要负责生成刘德华的代理人
     */
    static class LiuDeHuaInvocationHandler implements MethodInterceptor {

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            //如果调用的是代理对象的sing方法
            if (method.getName().equals("sing")){
                System.out.println("我是他的经纪人，要找他唱歌得先签合同付十万块钱！");
                //合同已签钱也付清，经纪人自己不会唱歌，就只能找刘德华去唱歌
                return proxy.invokeSuper(obj,args);//代理对象调用真实目标对象的sing方法去处理用户请求
            }
            //如果调用的是代理对象的dance方法
            if (method.getName().equals("dance")){
                System.out.println("我是他的经纪人，要找他跳舞得先签合同付二十万块钱！");
                //合同已签钱也付清，经纪人自己不会跳舞，就只能找刘德华去跳舞
                return proxy.invokeSuper(obj,args);//代理对象调用真实目标对象的dance方法去处理用户请求
            }
            return null;
        }
    }

    /**
     * 生成代理对象
     * @param cls
     * @param <T>
     * @return
     */
    private static <T> T getProxy(Class<T> cls) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cls);
        enhancer.setCallback(new LiuDeHuaInvocationHandler());
        return (T) enhancer.create();
    }

    public static void main(String[] args) {
        LiuDeHua proxyLiuDeHua = getProxy(LiuDeHua.class);
        System.out.println(proxyLiuDeHua.sing("笨小孩"));
        System.out.println(proxyLiuDeHua.dance("国标"));
    }

}
