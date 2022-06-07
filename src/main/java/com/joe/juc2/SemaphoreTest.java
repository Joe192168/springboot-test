package com.joe.juc2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

//模拟抢车位
public class SemaphoreTest {
    public static void main(String[] args) {
        //初始化3个车位
        Semaphore semaphore = new Semaphore(3);

        //相当有6个车抢3个车位
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();//得到
                    System.out.println("第"+Thread.currentThread().getName()+"车，抢到了车位");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("第"+Thread.currentThread().getName()+"车，离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();//释放
                }
            },String.valueOf(i)).start();
        }
    }
}
