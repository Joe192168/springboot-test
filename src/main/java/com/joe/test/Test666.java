package com.joe.test;

public class Test666 implements Runnable {
    public static Integer num = 100;

    private String name;

    public Test666(String name){
        this.name = name;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Test666("A"));
        Thread t2 = new Thread(new Test666("B"));
        Thread t3 = new Thread(new Test666("C"));

        t1.start();
        t2.start();
        t3.start();

    }

    @Override
    public void run() {
        while (true) {
            synchronized (num) {
                if(num>0) {
                    System.out.println(name + "窗口卖出一张票,剩余 " + --num + " 张票");
                }
            }
        }

    }
}