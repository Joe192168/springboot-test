package com.joe.thread;

//多个线程同时操作同一个对象
//模拟购买火车票
public class TestThread3 implements Runnable {

    //票数
    private int ticketNum = 10;

    @Override
    public void run() {
        while (true){
            if (ticketNum<=0){
                break;
            }
            //模拟延迟
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->拿到了第："+ticketNum--+"票");
        }
    }

    public static void main(String[] args) {
        TestThread3 ticket = new TestThread3();

        new Thread(ticket,"张三").start();
        new Thread(ticket,"李四").start();
        new Thread(ticket,"黄牛党").start();
    }
}
