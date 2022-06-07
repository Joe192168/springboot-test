package com.joe.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class Test4 {

    public void test1(Map<String,User> map, List<User> list){

    }

    public Map<String,User> test2(){
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {

        //通过反射，获取指定方法
        Method method = Test4.class.getDeclaredMethod("test1", Map.class, List.class);

        //获取泛型参数类型
        Type[] parameterTypes = method.getGenericParameterTypes();
        for (Type parameterType : parameterTypes) {
            System.out.println("有参数方法，泛型参数类型："+parameterType);
            //获取参数化类型
            if (parameterType instanceof ParameterizedType){
                Type[] actualTypeArguments = ((ParameterizedType) parameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println("有参数方法，参数化类型："+actualTypeArgument);
                }
            }
        }

        method = Test4.class.getDeclaredMethod("test2", null);
        Type genericReturnType = method.getGenericReturnType();
        //获取参数化类型
        if (genericReturnType instanceof ParameterizedType){
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println("无参数方法，参数化类型："+actualTypeArgument);
            }
        }
    }

}
