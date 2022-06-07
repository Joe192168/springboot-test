package com.joe.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SpinLockDemo {

    AtomicReference<Thread> atomicReference = new AtomicReference<Thread>();

    //加锁
    public void myLock(){
        Thread thread = Thread.currentThread();

        System.out.println(thread.getName()+"-> myLock");

        //自旋锁
        while (!atomicReference.compareAndSet(null,thread)) {

        }
    }

    //解锁
    public void myUnlock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"-> myUnlock");
        atomicReference.compareAndSet(thread,null);
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();

        new Thread(()->{
            spinLockDemo.myLock();

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                spinLockDemo.myUnlock();
            }
        },"A").start();

        new Thread(()->{
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                spinLockDemo.myUnlock();
            }
        },"B").start();
    }

}
