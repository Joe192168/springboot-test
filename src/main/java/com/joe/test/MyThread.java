package com.joe.test;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("111");
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.run();
    }
}
