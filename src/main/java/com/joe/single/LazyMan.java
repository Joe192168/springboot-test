package com.joe.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

//懒汉式单列模式
public class LazyMan {

    private static boolean flag = false;

    private LazyMan(){
        synchronized (LazyMan.class){
            if (flag==false){
                flag = true;
            }else{
                throw new RuntimeException("不能通过反射破坏单例模式异常！");
            }
        }

        System.out.println(Thread.currentThread().getName()+"-> ok");
    }

    private volatile static LazyMan lazyMan;

    //双重检测锁模式，懒汉式单例，DCL懒汉式
    public static LazyMan getInstance(){
        if (lazyMan==null){
            synchronized (LazyMan.class){
                if (lazyMan==null){
                    //极端情况下，如多线程，变量被改变，不能保证原子性操作，增加volatile关键字
                    lazyMan = new LazyMan();
                }
            }
        }
        return lazyMan;
    }

    //反射破坏单例
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        //LazyMan instance = LazyMan.getInstance();

        Field flag = LazyMan.class.getDeclaredField("flag");
        flag.setAccessible(true);

        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
        //私有权限破坏，无视私有构造器
        declaredConstructor.setAccessible(true);
        LazyMan instance1 = declaredConstructor.newInstance();

        flag.set(instance1,false);

        LazyMan instance2 = declaredConstructor.newInstance();

        System.out.println(instance1);
        System.out.println(instance2);
    }
}
