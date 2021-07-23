package juc2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

//同步队列，不存在丢失数据的问题
public class SynchronousQueueTest {

    public static void main(String[] args) {

        BlockingQueue blockingQueue = new SynchronousQueue();

        //存
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+" put a");
                blockingQueue.put("a");
                System.out.println(Thread.currentThread().getName()+" put b");
                blockingQueue.put("b");
                System.out.println(Thread.currentThread().getName()+" put c");
                blockingQueue.put("c");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T1").start();

        //取
        new Thread(()->{
            try {
                //延迟3秒
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"-->"+blockingQueue.take());
                //延迟3秒
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"-->"+blockingQueue.take());
                //延迟3秒
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"-->"+blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T2").start();

    }

}
