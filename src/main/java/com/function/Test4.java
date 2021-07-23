package com.function;

import java.util.function.Supplier;

//供给型接口：没有输入参数，只有返回值
public class Test4 {

    public static void main(String[] args) {

        /*Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "aaa";
            }
        };*/

        Supplier<String> supplier = ()->{return "aaa";};
        System.out.println(supplier.get());
    }
}
