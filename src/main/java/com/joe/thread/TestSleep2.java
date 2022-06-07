package com.joe.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

//模拟时间
public class TestSleep2 implements Runnable {

    @Override
    public void run() {
        //初始化时间
        Date date = new Date(System.currentTimeMillis());
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(date));
            //更新时间
            date = new Date(System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        new Thread(new TestSleep2()).start();
    }
}
