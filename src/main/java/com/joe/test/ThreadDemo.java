package com.joe.test;

public class ThreadDemo implements Runnable {
    int total = 1;
    boolean flag = true;

    @Override
    public void run() {

        while (flag) {
            synchronized (this) {
                notify();
                try {
                    Thread.currentThread();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (total <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + total);
                    total++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    flag = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadDemo t = new ThreadDemo();

        new Thread(t,"线程A").start();
        new Thread(t,"线程B").start();

    }
}