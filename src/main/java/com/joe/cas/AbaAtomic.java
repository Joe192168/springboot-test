package com.joe.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//ABA原子性
public class AbaAtomic {

    public static void main(String[] args) {

        //AtomicStampedReference 注意：如果泛型是一个包装类，注意对象的引用问题
        //正常在业务中，这里比较的都是一个对象
        AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<Integer>(1,1);

        new Thread(()->{
            //获取版本号
            int stamp = stampedReference.getStamp();
            System.out.println("a1->"+stamp);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Lock lock = new ReentrantLock();

            stampedReference.compareAndSet(1,
                    2, stampedReference.getStamp(), stampedReference.getStamp() + 1);

            System.out.println("a2->"+stampedReference.getStamp());

            boolean b2 = stampedReference.compareAndSet(2, 1,
                    stampedReference.getStamp(), stampedReference.getStamp() + 1);
            System.out.println(b2);
            System.out.println("a3->"+stampedReference.getStamp());
        },"a").start();

        //乐观锁的原理相同
        new Thread(()->{
            //获取版本号
            int stamp = stampedReference.getStamp();
            System.out.println("b1->"+stamp);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean b1 = stampedReference.compareAndSet(1, 6,
                    stamp, stamp + 1);
            System.out.println(b1);
            System.out.println("b2->"+stamp);
        },"b").start();

    }
    
}
