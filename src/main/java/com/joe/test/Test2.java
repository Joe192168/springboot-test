package com.joe.test;

public class Test2 implements Runnable {
    private static int num = 0;

    private String name;

    public Test2(String name){
        this.name = name;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Test2("A"));
        Thread t2 = new Thread(new Test2("B"));
        Thread t3 = new Thread(new Test2("C"));

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();

    }

    @Override
    public void run() {
        for(int i = 0;i<=100;i++){
            System.out.println(name+":"+i);
        }
    }
}