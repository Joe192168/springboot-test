package com.joe.thread;

public class TestThread2 implements Runnable {

    //线程入口
    @Override
    public void run() {
        //线程体
        for (int i = 0; i < 100; i++) {
            System.out.println("测试.............");
        }
    }

    //main主线程
    public static void main(String[] args) {
        //创建线程对象
        TestThread2 testThread2 = new TestThread2();
        //startThread1.start();

        new Thread(testThread2).start();

        //主线程方法
        for (int i = 0; i < 2000; i++) {
            System.out.println("我是第一个执行.......");
        }
    }

}
