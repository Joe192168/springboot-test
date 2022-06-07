package com.joe.function;

import java.util.function.Function;

//Function 函数式接口,有一个输入参数，有一个输出参数
public class Test1 {

    public static void main(String[] args) {
        //传统写法
        /*Function<String,String> com.joe.function = new Function<String,String>() {
            @Override
            public String apply(String str) {
                return str;
            }
        };*/

        //lambda表达式
        Function<String,String> function = (str)->{return str;};

        System.out.println(function.apply("a"));
    }

}
