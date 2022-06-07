package com.joe.volatile1;

import java.util.concurrent.atomic.AtomicInteger;

//Volatile原子性
public class Test3 implements Runnable {

    private /*volatile*/ static AtomicInteger num = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            num.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        for (int i = 1; i <= 20; i++) {
            new Thread(test3,String.valueOf(i)).start();
        }

        System.out.println(Thread.currentThread().getName()+"=>"+num);
    }

}
