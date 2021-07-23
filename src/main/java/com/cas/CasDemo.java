package com.cas;

import java.util.concurrent.atomic.AtomicInteger;

//ABA问题
public class CasDemo {

    //CAS compareAndSet：比较和替换
    public static void main(String[] args) {
        //初始值为：2020
        AtomicInteger atomicInteger = new AtomicInteger(2020);

        //如果达到了期望的值，就更新，否则不更新
        System.out.println(atomicInteger.compareAndSet(2020, 2021));
        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(2021, 2020));
        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(2020, 6666));
        System.out.println(atomicInteger.get());
    }

}
