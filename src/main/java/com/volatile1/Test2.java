package com.volatile1;

import java.util.concurrent.atomic.AtomicInteger;

//Volatile原子性
public class Test2 {

    private /*volatile*/ static AtomicInteger num = new AtomicInteger(0);

    //在不使用lock和synchronized的情况下次，保证结果的原子性
    public static void add(){
        //num++;
        num.getAndIncrement();//自增
        //num.incrementAndGet();
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                for (int k = 0; k < 1000; k++) {
                    add();
                }
            }).start();
        }

        //main和gc线程
        while (Thread.activeCount()>2){
            //礼让
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName()+"=>"+num);
    }

}
