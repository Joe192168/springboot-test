package com.thread;

public class TestDaemon {

    public static void main(String[] args) {

        Fish fish = new Fish();
        Water water = new Water();

        Thread thread = new Thread(fish);
        //默认是false表示用户线程，正常的线程都是用户线程
        thread.setDaemon(true);
        thread.start();

        //启动水线程
        new Thread(water).start();
        System.out.println("mian方法结束");
    }

}

//模拟鱼线程
class Fish implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("鱼儿快乐的遨游！");
        }
    }
}

//模拟水线程
class Water implements Runnable{

    @Override
    public void run() {
        //模拟水不停的减少，导致最后鱼儿死亡
        for (int i = 10; i > 0; i--) {
            System.out.println("鱼缸里的水越来越少-->"+i);
        }
        System.out.println("没有水了，鱼儿死了。");
    }
}
