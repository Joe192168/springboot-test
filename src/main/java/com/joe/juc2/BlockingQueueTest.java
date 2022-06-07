package com.joe.juc2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

//阻塞队列
public class BlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        test3();
    }

    //有返回值，抛出异常
    public static void test1(){
        //初始容量为3
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        //System.out.println(blockingQueue.add("d"));

        System.out.println("$$$$$$$$$$$$$$$$$");

        //获取队列首元素
        System.out.println("队列首元素"+blockingQueue.element());

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
    }

    //有返回值，没异常
    public static void test2(){
        //初始容量为3
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));

        System.out.println(blockingQueue.offer("d"));

        System.out.println("$$$$$$$$$$$$$$$$$");

        System.out.println("队列首元素"+blockingQueue.peek());

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());

        System.out.println(blockingQueue.poll());
    }

    //没返回值，阻塞等待
    public static void test3() throws InterruptedException {
        //初始容量为3
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);

        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");

        //blockingQueue.put("d");

        System.out.println("$$$$$$$$$$$$$$$$$");

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());

        //System.out.println(blockingQueue.take());
    }

    //有返回值，阻塞等待
    public static void test4() throws InterruptedException {
        //初始容量为3
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));

        //等待超时2秒就退出
        System.out.println(blockingQueue.offer("d",2, TimeUnit.SECONDS));

        System.out.println("$$$$$$$$$$$$$$$$$");

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());

        System.out.println(blockingQueue.take());
    }

}
