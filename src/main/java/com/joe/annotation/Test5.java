package com.joe.annotation;

import java.lang.annotation.ElementType;

//获取所有类型的class
public class Test5 {

    public static void main(String[] args) {
        //1 类
        Class c1 = Object.class;
        //2 接口
        Class c2 = Comparable.class;
        //3 一维数组
        Class c3 = String[].class;
        //4 二维数组
        Class c4 = int[][].class;
        //5 注解
        Class c5 = Override.class;
        //6 枚举
        Class c6 = ElementType.class;
        //7 基本数据类型
        Class c7 = Integer.class;
        //8 void
        Class c8 = void.class;
        //9 Class
        Class c9 = Class.class;

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);

    }

}
