package com.joe.proxy;

import java.lang.reflect.*;

/**
 * jdk实现动态代理
 */
public class JdkDynamicProxyTest {

    /**
     * 定义唱歌和跳舞接口
     */
     interface IPerson {
        //唱歌
        String sing(String name);
        //跳舞
        String dance(String name);
    }

    /**
     * 刘德华实现Person接口，那么他就会唱歌和跳舞了
     */
    static class LiuDeHua implements IPerson {
        @Override
        public String sing(String name) {
            System.out.println("刘德华唱" + name + "歌！！");
            return "歌曲唱完了，谢谢大家！";
        }

        @Override
        public String dance(String name) {
            System.out.println("刘德华跳" + name + "舞！！");
            return "舞跳完了，多谢各位观众！";
        }
    }

    /**
     * 这个代理类主要负责生成刘德华的代理人
     */
    static class LiuDeHuaInvocationHandler implements InvocationHandler {
        // 被代理的对象
        private Object realObj;

        public LiuDeHuaInvocationHandler(Object realObj) {
            this.realObj = realObj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //如果调用的是代理对象的sing方法
            if (method.getName().equals("sing")){
                System.out.println("我是他的经纪人，要找他唱歌得先签合同付十万块钱！");
                //合同已签钱也付清，经纪人自己不会唱歌，就只能找刘德华去唱歌
                return method.invoke(realObj,args);//代理对象调用真实目标对象的sing方法去处理用户请求
            }
            //如果调用的是代理对象的dance方法
            if (method.getName().equals("dance")){
                System.out.println("我是他的经纪人，要找他跳舞得先签合同付二十万块钱！");
                //合同已签钱也付清，经纪人自己不会跳舞，就只能找刘德华去跳舞
                return method.invoke(realObj,args);//代理对象调用真实目标对象的dance方法去处理用户请求
            }
            return null;
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        IPerson iperson = new LiuDeHua();
        //1、创建代理对象
        IPerson proxyIPerson = (IPerson)Proxy.newProxyInstance(
                iperson.getClass().getClassLoader(),
                iperson.getClass().getInterfaces(),
                new LiuDeHuaInvocationHandler(iperson));

        //2、通过Proxy.getProxyClass创建代理类定义，类定义会被缓存
        /*Class<?> proxyClass = Proxy.getProxyClass(
                iperson.getClass().getClassLoader(),
                iperson.getClass().getInterfaces());
        //获取代理类的构造方法，构造方法有一个InvocationHandler类型的参数
        Constructor<?> ctor = proxyClass.getConstructor(InvocationHandler.class);
        //创建InvocationHandler对象，创建代理类对象
        InvocationHandler handler = new LiuDeHuaInvocationHandler(iperson);
        //获取代理对象
        IPerson proxyIPerson = (IPerson) ctor.newInstance(handler);*/
        //调用代理对象的sing方法
        System.out.println(proxyIPerson.sing("笨小孩"));
        //调用代理对象的dance方法
        System.out.println(proxyIPerson.dance("国标"));
    }

}
