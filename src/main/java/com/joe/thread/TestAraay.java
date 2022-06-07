package com.joe.thread;

public class TestAraay {

    public static void main(String[] args) {

        TestA testA = new TestA();

        new Thread(()->{
            testA.getArr1();
        },"A").start();

        new Thread(()->{
            testA.getArr2();
        },"B").start();

    }

}

class TestA{

    private static boolean flag = true;

    int[] arr1 = new int[]{1, 3, 5, 7, 9};
    int[] arr2 = new int[]{2, 4, 6, 8, 10};

    public synchronized void getArr1(){
        for (int i = 0; i < arr1.length; i++) {
            if (!flag){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程A："+arr1[i]);
            flag = !flag;
            notifyAll();
        }
    }

    public synchronized void getArr2(){

        for (int i = 0; i < arr2.length; i++) {
            if (flag){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程B："+arr2[i]);
            flag = !flag;
            notifyAll();
        }

    }
}
