package com.juc;

//模拟卖票
public class SaleTicketTest {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(()->{ for (int i = 0; i < 30; i++) ticket.sale(); },"A").start();
        new Thread(()->{ for (int i = 0; i < 30; i++) ticket.sale(); },"B").start();
        new Thread(()->{ for (int i = 0; i < 30; i++) ticket.sale(); },"C").start();

    }

}

//普通卖票类
class Ticket{

    //票数
    private int num = 20;

    public synchronized void sale(){
        if (num>0){
            System.out.println(Thread.currentThread().getName()+"卖了第："+(num--)+"票，剩余："+num);
        }
    }

}
