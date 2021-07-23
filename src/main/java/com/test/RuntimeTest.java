package com.test;

public class RuntimeTest {

    public static void main(String[] args) {
        System.out.println("Total_memory="+Runtime.getRuntime().totalMemory()/(double)1024/1024+"M");
        System.out.println("Max_memory="+Runtime.getRuntime().maxMemory()/(double)1024/1024+"M");
    }

}
