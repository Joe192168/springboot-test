package com.joe.thread;

//模拟倒计时
public class TestSleep implements Runnable {

    //定义总数
    private int num = 10;

    @Override
    public void run() {
        while (true){
            try {
                //如果小于等于0就跳出
                if (num<=0){
                    break;
                }
                Thread.sleep(1000);
                System.out.println(num--);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new TestSleep()).start();
    }


}
