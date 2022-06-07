package com.joe.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 异步回调：CompletableFuture
 * 1、异步执行
 * 2、回调成功
 * 3、回调失败
 */
public class Demo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //没有返回值的异步回调
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"runAsync=>Void");
        });

        System.out.println("1111");

        completableFuture1.get();//获得阻塞执行结果


        //有返回值的异步回调
        //ajax：成功和失败的回调
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"supplyAsync=>String");
            //int i = 1/0;
            return "200";
        });

        System.out.println("2222");

        completableFuture2.whenComplete((t,u)->{
            System.out.println("t=>" + t);
            System.out.println("u=>" + u);
        }).exceptionally((e)->{
            System.out.println(e.getMessage());
            return "500";
        });

        System.out.println(completableFuture2.get());

    }

}
