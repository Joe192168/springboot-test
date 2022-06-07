package com.joe.vlass;

import java.lang.reflect.Method;

public class TestUser {

    public static void main(String[] args) {
        /*TestUser testUser = new TestUser();
        System.out.println(testUser.getClass());

        Class<TestUser> testUserClass = TestUser.class;
        System.out.println(testUserClass);*/

        try {
            Class<?> aClass = Class.forName("com.joe.vlass.TestUser");
            System.out.println(aClass);
            Method[] methods = aClass.getMethods();
            for (Method method : methods) {
                System.out.println(method.toString());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void test(){
        System.out.println("aaa");
    }

}
