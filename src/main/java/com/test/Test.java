package com.test;

public class Test {
    private volatile static int num = 0;
    private volatile static String state = "";

    public static void main(String[] args) {
        new Thread(() -> {
            while(num <= 100){
                if(state != "A"){
                    System.out.println("A:" + num++);
                    state = "A";
                    Thread.yield();
                }
            }
        }).start();

        new Thread(() -> {
            while(num <= 100){
                if(state != "B"){
                    System.out.println("B:" + num++);
                    state = "B";
                    Thread.yield();
                }
            }
        }).start();
    }
}