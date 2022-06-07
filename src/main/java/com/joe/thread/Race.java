package com.joe.thread;

//模拟龟兔赛跑
public class Race implements Runnable {

    //胜利者
    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            //模拟兔子睡觉
            /*if ("兔子".equals(Thread.currentThread().getName())&&i%10==0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/
            //调用比赛是否完成方法
            boolean flag = gemaOver(i);
            //比赛结束，就停止线程
            if (flag){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"-->跑了"+i+"步");
        }
    }

    //判断是否完成比赛
    private boolean gemaOver(int steps){
        //胜利者已产生
        if (winner!=null){
            return true;
        }{
            if (steps>=100){
                winner = Thread.currentThread().getName();
                System.out.println("胜利者是："+winner);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}
