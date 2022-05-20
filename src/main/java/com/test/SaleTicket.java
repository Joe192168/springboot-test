package com.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicket {

    private int tickets = 100;
    Lock lock = new ReentrantLock();

    public void sale() {
        lock.lock();
        try {
            if (tickets > 0) {
                System.out.println(Thread.currentThread().getName() + "正在售出第"+tickets+"还剩"+tickets--);
            }
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args)  {
        SaleTicket saleTicket = new SaleTicket();


        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                saleTicket.sale();
            }
        },"a").start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                saleTicket.sale();
            }
        },"b").start();


        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                saleTicket.sale();
            }
        },"c").start();
    }
}