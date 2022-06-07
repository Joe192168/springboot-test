package com.joe.annotation2;

@MyTest("验证注解的原理")
public class AnnotationTest {

    public static void main(String[] args) {
        MyTest myTest = AnnotationTest.class.getDeclaredAnnotation(MyTest.class);
        System.out.println(myTest.value());
    }

}
