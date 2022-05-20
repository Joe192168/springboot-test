package com.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Lock 可重复锁
public class Demo2 {

    public static void main(String[] args) {

        Phone2 phone = new Phone2();

        new Thread(()->{
            phone.sms();
        },"A").start();

        new Thread(()->{
            phone.sms();
        },"B").start();

    }

}

class Phone2{

    Lock lock = new ReentrantLock();

    public void sms(){
        lock.lock();
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"-> 发短信");
            call();//这里也有锁
        } finally {
            lock.unlock();
            lock.unlock();
        }
    }

    public void call(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"-> 打电话");
        } finally {
            lock.unlock();
        }
    }

}
