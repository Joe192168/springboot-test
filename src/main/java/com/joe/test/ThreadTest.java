package com.joe.test;

/**
 * @program: geometry-bi
 * @description:
 * @author: LF
 * @create: 2021/6/25 13:57
 * @version: 1.0.0
 */
public class ThreadTest extends  Thread {

    static int num = 1;
    static Integer in = new Integer(1);
    private String name;

    public ThreadTest(String name){
        this.name = name;
    }

    @Override
    public void run(){
        while (true){
            synchronized (in){
                if (num > 100){
                    System.exit(0);
                }else {
                    System.out.println(name+num);
                    num++;
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            ThreadTest a = new ThreadTest("A");
            a.start();
            ThreadTest b = new ThreadTest("B");
            b.start();
        }catch (Exception e){

        }

    }
}