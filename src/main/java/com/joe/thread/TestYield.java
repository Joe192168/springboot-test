package com.joe.thread;

//线程礼让
public class TestYield implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始执行");
        //礼让
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"线程结束执行");
    }

    public static void main(String[] args) {
        TestYield testYield = new TestYield();

        new Thread(testYield,"a").start();
        new Thread(testYield,"b").start();
    }
}
