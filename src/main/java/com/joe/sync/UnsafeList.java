package com.joe.sync;

import java.util.ArrayList;
import java.util.List;

//模拟不安全List集合
public class UnsafeList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
//                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                System.out.println(list.size());
//                }
            }).start();
        }
        //增加延时，list集合的size才正常
        /*try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println(list.size());
    }

}
