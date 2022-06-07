package com.joe.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Lock使用
public class AS2 {

    public static void main(String[] args) {
        Data2 data = new Data2();

        new Thread(()-> {for (int i = 0; i < 10; i++)data.add();},"A").start();
        new Thread(()-> {for (int i = 0; i < 10; i++)data.cut();},"B").start();

        new Thread(()-> {for (int i = 0; i < 10; i++)data.add();},"C").start();
        new Thread(()-> {for (int i = 0; i < 10; i++)data.cut();},"D").start();
    }

}

class Data2{

    private int num = 0;
    //定义锁
    Lock lock = new ReentrantLock();
    //监视器方法
    Condition condition = lock.newCondition();

    //加
    public void add(){
        //加锁
        lock.lock();
        try {
            while (num!=0){
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"-->"+num);
            //通知其它线程，+1完毕
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //解锁
            lock.unlock();
        }
    }

    //键
    public void cut(){
        //加锁
        lock.lock();
        try {
            while (num==0){
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+"-->"+num);
            //通知其它线程，-1完毕
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}


