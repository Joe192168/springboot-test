package com.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Lock使用和Condition精准通知唤醒其它线程
public class AS3 {

    public static void main(String[] args) {
        Data3 data = new Data3();

        new Thread(()-> {for (int i = 0; i < 10; i++)data.printA();},"A").start();
        new Thread(()-> {for (int i = 0; i < 10; i++)data.printB();},"B").start();
        new Thread(()-> {for (int i = 0; i < 10; i++)data.printC();},"C").start();
    }

}

class Data3{

    private int num = 1;
    //定义锁
    private Lock lock = new ReentrantLock();
    //监视器方法
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void printA(){
        //加锁
        lock.lock();
        try {
            while (num!=1){
                condition1.await();
            }
            num = 2;
            System.out.println(Thread.currentThread().getName()+"AAA");
            //通知其它线程
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //解锁
            lock.unlock();
        }
    }

    public void printB(){
        //加锁
        lock.lock();
        try {
            while (num!=2){
                condition2.await();
            }
            num = 3;
            System.out.println(Thread.currentThread().getName()+"BBB");
            //通知其它线程
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC(){
        //加锁
        lock.lock();
        try {
            while (num!=3){
                condition3.await();
            }
            num =1;
            System.out.println(Thread.currentThread().getName()+"CCC");
            //通知其它线程
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}


