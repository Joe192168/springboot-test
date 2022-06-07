package com.joe.jvm;

/**
 * VM参数 :
 * -verbose:gc
 * -Xms20M
 * -Xmx20M
 * -Xmn10M
 * -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8
 * -XX:PretenureSizeThreshold=3145728       //对象如果大于或等于此值,会直接分配到老年代里
 * -XX:+UseSerialGC                         //使用Serial收集器(使用其他收集器不一定行)
 */
public class OldTest {
    
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] bigBytes = new byte[4 * _1MB];
    }

}