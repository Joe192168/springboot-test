package com.test;

public class Test445 implements Runnable{

    public int num = 1;

    public static void main(String[] args) {
        Test445 t = new Test445();
        new Thread(t, "A").start();
        new Thread(t, "B").start();
    }


    @Override
    public void run() {
        synchronized (this) {
            while (num <= 100) {
                this.notify();
                System.out.println(Thread.currentThread().getName() + ":" + num++);
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}