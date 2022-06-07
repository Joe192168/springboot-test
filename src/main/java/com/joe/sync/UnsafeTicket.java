package com.joe.sync;

//模拟不安全抢票
//线程不安全，出现负数的票
public class UnsafeTicket implements Runnable {

    //标识符
    private boolean flag = true;
    //票数
    private int num = 10;

    @Override
    public void run() {
        //模拟抢票
        while (flag){
            buy();
        }
    }

    //买票方法
    public synchronized void buy(){
        //判断是否有票
        if (num<=0){
            flag = false;
            return;
        }
        //模拟延时
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"购买了第"+num--+"张票");
    }

    public static void main(String[] args) {
        UnsafeTicket unsafeTicket = new UnsafeTicket();

        new Thread(unsafeTicket,"自己").start();
        new Thread(unsafeTicket,"路人甲").start();
        new Thread(unsafeTicket,"黄牛党").start();
    }
}
