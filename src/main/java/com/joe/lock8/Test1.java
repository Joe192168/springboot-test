package com.joe.lock8;

import java.util.concurrent.TimeUnit;

//问题1
//1、标准情况下，两个线程谁先打印，发短信，还是打电话
//2、sendSms延迟4秒，两个线程谁先打印，发短信，还是打电话
public class Test1 {

    public static void main(String[] args) {
        Phone phone = new Phone();

        Phone phone2 = new Phone();

        new Thread(()->{phone.sendSms();},"A").start();

        try {
            //休息1秒
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{phone2.call();},"B").start();
    }

}

class Phone{

    //synchronized锁的对象是方法的调用者
    //两个方法用的是同一个锁，谁先拿到就先执行
    public synchronized void sendSms(){
        try {
            //休息1秒
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call(){
        System.out.println("打电话");
    }

}
