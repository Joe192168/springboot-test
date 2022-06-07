package com.joe.wait;

//线程通信-->信号灯法
public class TestTv {

    public static void main(String[] args) {
        Tv tv = new Tv();

        new Actor(tv).start();
        new Viewer(tv).start();
    }

}

//观众
class Viewer extends Thread{
    Tv tv;

    public Viewer(Tv tv) {
        this.tv = tv;
    }

    //观看
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}

//演员
class Actor extends Thread{
    Tv tv;

    public Actor(Tv tv) {
        this.tv = tv;
    }

    //表演节目
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i%2==0){
                tv.Play("新闻联播");
            }else{
                tv.Play("播放广告10秒，请稍后观看节目！");
            }
        }
    }
}

//电视
class Tv{

    //节目内容
    private String name;
    //标示
    // 1、演员表演，观众等待 T
    // 2、观众观看，演员等待 F
    boolean flag = true;

    //表演
    public synchronized void Play(String name){
        if (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了："+name);
        //演员表演节目
        this.name = name;
        //通知观众观看
        this.notifyAll();
        this.flag = !flag;
    }

    //观看
    public synchronized void watch(){
        if (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //观众观看
        System.out.println("观众观看了："+name);
        //通知演员表演
        this.notifyAll();
        this.flag = !flag;
    }

}