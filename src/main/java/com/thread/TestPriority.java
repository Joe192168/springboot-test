package com.thread;

//测试线程优先级
public class TestPriority implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        TestPriority testPriority = new TestPriority();

        Thread t1 = new Thread(testPriority,"线程1");
        Thread t2 = new Thread(testPriority,"线程2");
        Thread t3 = new Thread(testPriority,"线程3");

        //默认优先级为：5，也就是NORM_PRIORITY
        t1.start();

        //设置优先级为1
        t2.setPriority(1);
        t2.start();

        //设置优先级为默认最大值
        t3.setPriority(Thread.MAX_PRIORITY);
        t3.start();

        //线程设置优先级，不一定是按照优先级启动的，还得看CPU的情况。

    }

}
