package com.joe.connection;

/**
 * 线程上下文类加载器用法
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
    }

}
