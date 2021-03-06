package com.joe.lock8;

import java.util.concurrent.TimeUnit;

//问题3
//给发短信方法加上static，打电话不加static
public class Test6 {

    public static void main(String[] args) throws InterruptedException {
        //两个对象的Class类模板只有一个，static，锁的是Class
        Phone6 phone = new Phone6();

        new Thread(()->{phone.sendSms();},"A").start();
        //休息1秒
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{phone.call();},"B").start();
    }

}

class Phone6{

    //synchronized锁的对象是方法的调用者
    //两个方法用的是同一个锁，谁先拿到就先执行
    public static synchronized void sendSms(){
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
