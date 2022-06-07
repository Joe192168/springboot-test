package com.joe.juc2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

    public static void main(String[] args) {
        MyCacheLock myCacheLock = new MyCacheLock();

        //多线程写入
        for (int i = 1; i <= 3; i++) {
            final int temp = i;
            new Thread(()->{
                myCacheLock.put(temp+"",temp+"");
            },String.valueOf(i)).start();
        }

        //多线程读取
        for (int i = 1; i <= 3; i++) {
            final int temp = i;
            new Thread(()->{
                myCacheLock.get(temp+"");
            },String.valueOf(i)).start();
        }
    }

}

//自定缓存
class MyCacheLock{

    private volatile Map<String,Object> map = new HashMap<String,Object>();
    //读写锁，更加细粒度的控制
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock lock = new ReentrantLock();

    //写入，写入的时候，只希望同时只有一个线程
    public void put(String key,String value){
        lock.lock();
        try {
            System.out.println("写入"+key);
            map.put(key,value);
            System.out.println("写入Ok");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           lock.unlock();
        }
    }

    //读取，所有线程都可以同时读取
    public void get(String key){
        lock.lock();
        try {
            System.out.println("读取"+key);
            Object o = map.get(key);
            System.out.println("读取Ok");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
