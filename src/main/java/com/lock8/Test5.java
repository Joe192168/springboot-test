package com.lock8;

import java.util.concurrent.TimeUnit;

//问题3
//给方法加上static
public class Test5 {

    public static void main(String[] args) throws InterruptedException {
        //两个对象，两个调用者，两把锁
        Phone5 phone1 = new Phone5();
        Phone5 phone2 = new Phone5();

        new Thread(()->{phone1.sendSms();},"A").start();
        //休息1秒
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{phone2.call();},"B").start();
    }

}

class Phone5{

    //synchronized锁的对象是方法的调用者
    //两个方法用的是同一个锁，谁先拿到就先执行
    public static synchronized void sendSms(){
        try {
            //休息1秒
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public static synchronized void call(){
        System.out.println("打电话");
    }

}
