package com.joe.juc2;

import java.util.*;

//java.util.ConcurrentModificationException 并发异常
public class TestList {

    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<>());

        for (int i = 1; i <= 1000; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }

    }

}
