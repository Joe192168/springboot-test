package com.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test1 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("com.reflection.User");

        //1、获得类的名字
        System.out.println(c1.getName()); //包名 + 类名
        System.out.println(c1.getSimpleName()); // 类名

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");

        //2、获得类的属性
        Field[] fields = c1.getFields(); //只能找到public属性

        fields = c1.getDeclaredFields(); //获取的全部属性

        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");

        //3、获取的指定属性
        //Field name = c1.getField("name"); //只能获得public的属性
        Field name1 = c1.getDeclaredField("name");
        System.out.println(name1);


        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");

        //4、获得类的方法
        Method[] methods = c1.getMethods(); //获得本类及其父类的全部public方法
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");

        methods = c1.getDeclaredMethods(); //获得本类的所有方法

        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");

        //5、获得指定方法
        Method getName = c1.getMethod("getName", null);
        System.out.println(getName);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(setName);

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");

        //6、获得构造器
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        //获取指定的构造器
        Constructor constructor = c1.getConstructor(String.class, int.class, int.class);
        System.out.println(constructor);
    }

}
