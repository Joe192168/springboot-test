package com.joe.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//使用Runnable实现线程池
public class TestPool {

    public static void main(String[] args) {
        //创建线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        //执行线程
        service.execute(new MyThreadPool());
        service.execute(new MyThreadPool());
        service.execute(new MyThreadPool());

        //关闭线程池
        service.shutdown();
    }

}

class MyThreadPool implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
