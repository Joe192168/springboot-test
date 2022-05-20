package com.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Test2 {

    private static boolean flag = false;

    public Test2(){
        synchronized (Test2.class){
            if (flag==false){
                flag = true;
            }else{
                throw new RuntimeException("不能通过反射破坏单例模式异常！");
            }
        }

        System.out.println(Thread.currentThread().getName()+"-> ok");
    }

    private volatile static Test2 Test2;

    //双重检测锁模式，懒汉式单例，DCL懒汉式
    public static Test2 getInstance(){
        if (Test2==null){
            synchronized (Test2.class){
                if (Test2==null){
                    //极端情况下，如多线程，变量被改变，不能保证原子性操作，增加volatile关键字
                    Test2 = new Test2();
                }
            }
        }
        return Test2;
    }

    //反射破坏单例
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        //Test2 instance = Test2.getInstance();

        Field flag = Test2.class.getDeclaredField("flag");
        flag.setAccessible(true);

        Constructor<Test2> declaredConstructor = Test2.class.getDeclaredConstructor(null);
        //私有权限破坏，无视私有构造器
        declaredConstructor.setAccessible(true);
        Test2 instance1 = declaredConstructor.newInstance();

        flag.set(instance1,false);

        Test2 instance2 = declaredConstructor.newInstance();

        System.out.println(instance1);
        System.out.println(instance2);
    }
    
}
