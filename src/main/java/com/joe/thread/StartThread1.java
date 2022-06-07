package com.joe.thread;

//创建线程方式1
public class StartThread1 extends Thread {

    //线程入口
    @Override
    public void run() {
        //线程体
        for (int i = 0; i < 5; i++) {
           System.out.println("测试.............");
        }
    }

    //main主线程
    public static void main(String[] args) {
        //创建线程对象
        StartThread1 startThread1 = new StartThread1();
        startThread1.start();

        //主线程方法
        for (int i = 0; i < 5; i++) {
            System.out.println("我是第一个执行.......");
        }
    }

}
