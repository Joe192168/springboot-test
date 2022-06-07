package com.joe.test;

public class StringTest {

    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        System.out.println(stringClass.getClassLoader());
        //this.getClass().getClassLoader().loadClass("className");
    }

}
