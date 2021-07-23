package com.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test2 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获取class
        Class c1 = Class.forName("com.reflection.User");

        //本质是调用了类的无参构造函数，创建对象
        User user1 = (User)c1.newInstance();
        System.out.println(user1);

        //没有无参构造器，通过有参构造器创建对象
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User user2 = (User)constructor.newInstance("张三", 1, 18);
        System.out.println(user2);

        //通过反射调用普通方法
        User user3 = (User)c1.newInstance();
        Method setName = c1.getDeclaredMethod("setName", String.class);

        //invoke：激活的意思
        //（对象，方法的值）
        setName.invoke(user3,"李四");
        System.out.println(user3.getName());

        System.out.println("######################");
        //通过反射操作属性
        User user4 = (User)c1.newInstance();
        Field name = c1.getDeclaredField("name");

        //不能直接操作私有属性，需要关闭程序的安全策略，属性或者方法的setAccessible
        name.setAccessible(true);

        name.set(user4,"测试");
        System.out.println(user4.getName());
    }

}
