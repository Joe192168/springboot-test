package com.test;

public class Test1 implements Runnable {
    private static int num = 0;

    private String name;

    public Test1(String name){
        this.name = name;
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1("A");
        Test1 test2 = new Test1("B");

        new Thread(test1).start();
        new Thread(test2).start();
    }

    @Override
    public void run() {
        while (num <= 100) {
            try {
                System.out.println(name + ":" + num++);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}