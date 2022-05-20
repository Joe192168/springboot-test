package com.lock8;

import java.util.concurrent.TimeUnit;

//执行完，打印，com.test，还是发短信
public class Test3 {

    public static void main(String[] args) throws InterruptedException {
        Phone3 phone = new Phone3();

        new Thread(()->{phone.sendSms();},"A").start();
        //休息1秒
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{phone.test();},"B").start();
    }

}

class Phone3{

    //synchronized锁的对象是方法的调用者
    //两个方法用的是同一个锁，谁先拿到就先执行
    public synchronized void sendSms(){
        try {
            //休息1秒
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call(){
        System.out.println("打电话");
    }

    public void test(){
        System.out.println("com/test");
    }

}
