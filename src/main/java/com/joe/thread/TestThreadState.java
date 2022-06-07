package com.joe.thread;

public class TestThreadState {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("$$$$$$");
        });

        //观察状态
        Thread.State state = thread.getState();
        System.out.println(state); //NEW

        //启动线程
        thread.start();
        state = thread.getState(); //更新线程状态
        System.out.println(state); //RUNNABLE

        //只要线程不终止，就一直执行
        while (state!=Thread.State.TERMINATED){
            Thread.sleep(100);
            state = thread.getState();//更新线程状态
            System.out.println(state); //TERMINATED
        }
        thread.getPriority();
        thread.setPriority(1);
    }

}
