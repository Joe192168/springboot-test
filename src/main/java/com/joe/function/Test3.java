package com.joe.function;

import java.util.function.Consumer;

//Consumer 消费者接口：只有输入，没有返回值
public class Test3 {

    public static void main(String[] args) {
        //传统写法
        /*Consumer consumer = new Consumer<String>() {
            @Override
            public void accept(String str) {
                System.out.println(str);
            }
        };*/

        Consumer consumer = (str)->{System.out.println(str);};
        consumer.accept("ss");
    }

}
