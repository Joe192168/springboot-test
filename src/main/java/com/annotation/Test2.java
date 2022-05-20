package com.annotation;

import java.lang.annotation.*;

@MyAnnotation
public class Test2 {

    @MyAnnotation
    private String str;

    @MyAnnotation
    public void ceShi(){

    }

}

//定义一个注解
//Target: 表示该注解可以在哪些地方使用，如：规定智能在类或接口，方法上使用
@Target(value={ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
//Retention：表示注解在什么情况下还有效
@Retention(value = RetentionPolicy.RUNTIME)
//Documented：表示该注解是否生成在javadoc中
@Documented
//Inherited：子类可以继承父类的注解
@Inherited
@interface MyAnnotation{

}
