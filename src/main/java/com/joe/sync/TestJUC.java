package com.joe.sync;

import java.util.concurrent.CopyOnWriteArrayList;

public class TestJUC {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
                System.out.println(list.size());
            }).start();
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }

}
