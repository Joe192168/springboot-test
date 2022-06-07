package com.joe.test;

public class Test7 {
    private static volatile int num = 100;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while(num > 0){
                System.out.println("A买票1张，余票：" + --num);
            }
        });

        Thread t2 = new Thread(() -> {
            while(num > 0){
                System.out.println("B买票1张，余票：" + --num);
            }
        });

        Thread t3 = new Thread(() -> {
            while(num > 0){
                System.out.println("C买票1张，余票：" + --num);
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}