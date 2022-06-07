package com.joe.juc2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallabelTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();

        //相当一个中间商，做代理
        FutureTask futureTask = new FutureTask<>(myThread);

        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();

        Integer ret = (Integer) futureTask.get();

        System.out.println(ret);
    }

}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("call...");
        return 1024;
    }
}
