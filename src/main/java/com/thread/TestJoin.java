package com.thread;

//测试Join，理解插队
public class TestJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("我是VIP，优先办理业务。");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        //静态代理
        Thread thread = new Thread(testJoin);
        thread.start();

        //主线程
        for (int i = 0; i < 100; i++) {
            System.out.println("主业务执行"+i);
            if (i==5){
                //插队
                thread.join();
            }
        }
    }
}
