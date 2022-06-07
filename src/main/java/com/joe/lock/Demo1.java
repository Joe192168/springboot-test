package com.joe.lock;

//synchronized 可重复锁
public class Demo1 {

    public static void main(String[] args) {

        Phone phone = new Phone();

        new Thread(()->{
            phone.sms();
        },"A").start();

        new Thread(()->{
            phone.sms();
        },"B").start();

    }

}

class Phone{

    public synchronized void sms(){
        System.out.println(Thread.currentThread().getName()+"-> 发短信");
        call();//这里也有锁
    }

    public synchronized void call(){
        System.out.println(Thread.currentThread().getName()+"-> 打电话");
    }

}
