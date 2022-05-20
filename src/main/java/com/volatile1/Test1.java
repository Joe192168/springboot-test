package com.volatile1;

import java.util.concurrent.TimeUnit;

//Volatile可见性
public class Test1 {

    //不加volatile 程序就会出现死循环
    //加上volatile 程序就可以正常执行
    private volatile static int num = 0;

    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{
            while (num==0){

            }
        }).start();

        //延迟1秒
        TimeUnit.SECONDS.sleep(1);

        num = 1;

        System.out.println(num);

    }

}
