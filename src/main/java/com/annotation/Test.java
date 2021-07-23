package com.annotation;


public class Test extends Object{

    private String name;

    @Override
    public String toString() {
        return "Test{}";
    }

    @Deprecated
    public static void tss(){
        System.out.println("不推荐使用");
    }

    public static void main(String[] args) {
        Test.tss();
    }
}
