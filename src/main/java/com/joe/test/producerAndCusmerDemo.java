package com.joe.test;

public class producerAndCusmerDemo {
   static int num = 0;
   static Object o = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            while(true){
                synchronized (o){
                    if(num == 0){
                        try {
                            System.out.println("生产产品"+(num+1)+"个，现有产品："+ ++num);
                            o.notifyAll();
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while(true){
                synchronized (o){
                    if(num > 0){
                        System.out.println("消费产品"+num+"个，现有产品："+ --num);
                        try {
                            o.notifyAll();
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
}