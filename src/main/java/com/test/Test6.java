package com.test;

public class Test6 {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            int num = 0;
            while(num <= 100){
                System.out.println("A:" + num++);
            }
        });

        Thread t2 = new Thread(() -> {
            int num = 0;
            while(num <= 100){
                System.out.println("B:" + num++);
            }
        });

        Thread t3 = new Thread(() -> {
            int num = 0;
            while(num <= 100){
                System.out.println("C:" + num++);
            }
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}