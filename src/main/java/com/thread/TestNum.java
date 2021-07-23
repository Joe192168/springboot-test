package com.thread;

public class TestNum {

    public static void main(String[] args) {
        TestPrint testNum = new TestPrint();
        new Thread(()->{
            testNum.printA();
        },"A").start();
        new Thread(()->{
            testNum.printB();
        },"B").start();
    }

    static class TestPrint{

        private static boolean flag = true;
        private static int num = 0;

        public synchronized void printA(){
            for (int i = 1; i <= 50; i++) {
                if (!flag){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("A打印输出："+ ++num);
                flag = !flag;
                notifyAll();
            }

        }

        public synchronized void printB(){
            for (int i = 1; i <= 50; i++) {
                if (flag){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("B打印输出："+ ++num);
                flag = !flag;
                notifyAll();
            }
        }
    }

}
