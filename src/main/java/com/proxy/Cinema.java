package com.proxy;

//电影院实现电影接口
public class Cinema implements Movie {

    RealMovie realMovie;

    //通过构造方法，传递对象
    public Cinema(RealMovie realMovie){
        this.realMovie = realMovie;
    }

    @Override
    public void play() {
        guangGao(true);
        realMovie.play();
        guangGao(false);
    }

    public void guangGao(boolean flag){
        if (flag){
            System.out.println("电影马上开始了，爆米花、可乐、口香糖9.8折，快来买啊！");
        }else{
            System.out.println("电影马上结束了，爆米花、可乐、口香糖9.8折，买回家吃吧！");
        }
    }
}
