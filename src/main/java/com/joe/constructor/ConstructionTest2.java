package com.joe.constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

public class ConstructionTest2 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class<?> clazz = null;

        //获取Class对象的引用
        clazz = Class.forName("com.joe.constructor.User");

        Constructor cs3 = clazz.getDeclaredConstructor(int.class,String.class);
        System.out.println("-----getDeclaringClass-----");
        Class uclazz=cs3.getDeclaringClass();
        //Constructor对象表示的构造方法的类
        System.out.println("构造方法的类:"+uclazz.getName());

        System.out.println("-----getGenericParameterTypes-----");
        //对象表示此 Constructor 对象所表示的方法的形参类型
        Type[] tps=cs3.getGenericParameterTypes();
        for (Type tp:tps) {
            System.out.println("参数名称tp:"+tp);
        }
        System.out.println("-----getParameterTypes-----");
        //获取构造函数参数类型
        Class<?> clazzs[] = cs3.getParameterTypes();
        for (Class claz:clazzs) {
            System.out.println("参数名称:"+claz.getName());
        }
        System.out.println("-----getName-----");
        //以字符串形式返回此构造方法的名称
        System.out.println("getName:"+cs3.getName());

        System.out.println("-----getoGenericString-----");
        //返回描述此 Constructor 的字符串，其中包括类型参数。
        System.out.println("getoGenericString():"+cs3.toGenericString());
    }

}
