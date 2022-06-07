package com.joe.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//模拟卖票
public class SaleTicketTest2 {

    public static void main(String[] args) {
        Ticket2 ticket = new Ticket2();

        new Thread(()->{ for (int i = 0; i < 40; i++) ticket.sale(); },"A").start();
        new Thread(()->{ for (int i = 0; i < 40; i++) ticket.sale(); },"B").start();
        new Thread(()->{ for (int i = 0; i < 40; i++) ticket.sale(); },"C").start();

    }

}

//普通卖票类
class Ticket2{

    //票数
    private int num = 30;

    public void sale(){
        //创建锁
        Lock lock = new ReentrantLock();

        //加锁
        lock.lock();
        try {
            if (num>0){
                System.out.println(Thread.currentThread().getName()+"卖了第："+(num--)+"票，剩余："+num);
            }
        } finally {
            //解锁
            lock.unlock();
        }
    }

}
