package com.volatile1;

public class Test4 {
    private static int num = 0;

    //在不使用lock和synchronized的情况下次，保证结果的原子性
    public static void add(){
        num++;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                for (int k = 1; k <= 1000; k++) {
                    add();
                }
            }).start();
        }
        //main和gc线程
        while (Thread.activeCount()>2){
            //礼让
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"=>"+num);
    }
}
