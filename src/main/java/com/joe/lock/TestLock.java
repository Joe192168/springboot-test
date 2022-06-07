package com.joe.lock;

import java.util.concurrent.locks.ReentrantLock;

//模拟抢票，使用Lock锁，解决线程并发
public class TestLock {

    public static void main(String[] args) {
        Tickets tickets = new Tickets();

        new Thread(tickets).start();
        new Thread(tickets).start();
        new Thread(tickets).start();
    }

}

class Tickets implements Runnable{

    //定义锁
    private final ReentrantLock lock = new ReentrantLock();

    //票数
    private int num = 10;

    @Override
    public void run() {
        try{
            //加锁
            lock.lock();
            while (true){
                if (num>0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("开始抢票了，数量为："+num--);
                }else {
                    break;
                }
            }
        }finally {
            //解锁
            lock.unlock();
        }

    }
}