package com.joe.annotation2;

import org.springframework.beans.factory.annotation.Autowired;

@MyTest("验证注解的原理")
public class AnnotationTest {

    public static void main(String[] args) {
        MyTest myTest = AnnotationTest.class.getDeclaredAnnotation(MyTest.class);
        System.out.println(myTest.value());

        /*try {
            // 获得Class对象
            Class<?> c1 = Class.forName("com.joe.annotation2.RetentionTest");
            // 创造一个对象
            RetentionTest user = (RetentionTest) c1.newInstance();// 本质是使用无参构造器
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }*/

    }

}

