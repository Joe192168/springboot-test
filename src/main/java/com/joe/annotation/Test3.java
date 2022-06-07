package com.joe.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Test3 {

    @MyAnnotation2(name="测试")
    private void method1(){

    }

    @MyAnnotation3("测试")
    private void method2(){

    }

}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{

    String name() default "";
    int age() default 1;

}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3{

    //使用value，且只有一个参数，可以省略
    String value();

}


