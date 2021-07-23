package com.proxy;

public class ProxyTest {

    public static void main(String[] args) {
        /*//创建真正实现电影的类对象
        RealMovie realMovie = new RealMovie();
        //通过电影院类代理
        Movie movie = new Cinema(realMovie);
        //调用播放功能
        movie.play();*/

        //通过电影院类代理播放电影
        new Cinema(new RealMovie()).play();

        new Thread(()-> System.out.println("电影开始了，请安静！")).start();
    }

}
