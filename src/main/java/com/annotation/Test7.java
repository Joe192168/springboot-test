package com.annotation;

//分析类的初始化
public class Test7 {

    static {
        System.out.println("Main被加载了");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //1 new 主动引用
        //Son son = new Son();

        //2 反射引发主动引用
        //Class.forName("com.annotation.Son");

        //3 调用父类的静态变量 子类不会引发主动引用
        System.out.println(Son.a);

        //4 数组不会引发主动引用
        //Son[] array = new Son[10];
    }

}

class Father{

    static int a = 1;

    static {
        System.out.println("父类被加载了");
    }

}

class Son extends Father{

    static {
        System.out.println("子类被加载了");
        b = 200;
    }

    static int b = 100;
    static final int M = 2;

}
