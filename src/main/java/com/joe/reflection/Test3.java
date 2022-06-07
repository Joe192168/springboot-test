package com.joe.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test3 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        test1();
        test2();
        test3();
    }


    //普通方式，调用需要多长时间
    public static void test1(){
        //通过new 创建对象
        User user = new User();

        //开始时间
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            user.getName();
        }

        //结束时间
        long endTime = System.currentTimeMillis();

        System.out.println("普通方式调用，所需要的时间："+(endTime-startTime)+"ms");
    }

    //反射方式，调用需要多长时间
    public static void test2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        //获取Class对象
        Class c1 = Class.forName("com.joe.reflection.User");
        //通过反射 newInstance 创建对象
        User user = (User) c1.newInstance();
        //获取指定方法
        Method getName = c1.getDeclaredMethod("getName", null);

        //开始时间
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user,null);
        }

        //结束时间
        long endTime = System.currentTimeMillis();

        System.out.println("反射方式调用，所需要的时间："+(endTime-startTime)+"ms");
    }

    //反射方式，设置setAccessible，调用需要多长时间
    public static void test3() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        //获取Class对象
        Class c1 = Class.forName("com.joe.reflection.User");
        //通过反射 newInstance 创建对象
        User user = (User) c1.newInstance();
        //获取指定方法
        Method getName = c1.getDeclaredMethod("getName", null);

        //关闭检查
        getName.setAccessible(true);

        //开始时间
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user,null);
        }

        //结束时间
        long endTime = System.currentTimeMillis();

        System.out.println("反射方式并关闭检查调用，所需要的时间："+(endTime-startTime)+"ms");
    }
}
