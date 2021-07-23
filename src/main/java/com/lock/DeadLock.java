package com.lock;

public class DeadLock {

    public static void main(String[] args) {
        Game game1 = new Game(0,"小明");
        Game game2 = new Game(1,"小红");

        new Thread(game1).start();
        new Thread(game2).start();
    }
}

//玩具
class Toys {

}

//零食
class Snacks {

}

//开始玩游戏
class Game implements Runnable{

    static Toys toys = new Toys();
    static Snacks snacks = new Snacks();
    //选择标示
    private int flag;
    //玩游戏小孩的名字
    private String name;

    public Game(int flag, String name) {
        this.flag = flag;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            PlayGame();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void PlayGame() throws InterruptedException {
        if (flag==0){
            //获得玩具的锁
            synchronized (toys){
                System.out.println(this.name+",玩玩具");
                //延时一秒，后吃零食
                Thread.sleep(1000);
                //获得零食的锁
                synchronized (snacks){
                    System.out.println(this.name+",吃零食");
                }
            }
        }else{
            //获得零食的锁
            synchronized (snacks){
                System.out.println(this.name+",吃零食");
                //延时一秒，后吃玩玩具
                Thread.sleep(1000);
                //获得玩具的锁
                synchronized (toys){
                    System.out.println(this.name+",玩玩具");
                }
            }
        }
    }
}