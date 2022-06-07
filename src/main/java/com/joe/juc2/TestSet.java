package com.joe.juc2;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class TestSet {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        //1、Set<String> set = Collections.synchronizedSet(new HashSet<>());
        //2、Set<String> set = new CopyOnWriteArraySet<>();

        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            },String.valueOf(i)).start();
        }

    }

}
