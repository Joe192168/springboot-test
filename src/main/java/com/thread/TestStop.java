package com.thread;

public class TestStop implements Runnable {

    //1、设置一个标识符
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag){
            System.out.println("线程开始运行了"+i++);
        }
    }

    //2、设置一个公开的方法，改变标识符
    public void stop(){
        this.flag = false;
    }

    public static void main(String[] args) {

        TestStop testStop = new TestStop();
        //启动线程
        new Thread(testStop).start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main"+i);
            if (i==90){
                //调用公开的方法，改变标识符
                testStop.stop();
                System.out.println("停止了");
            }
        }

    }

}
