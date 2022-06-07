package com.joe.juc;

//Synchronizd使用
public class AS {

    public static void main(String[] args) {
        Data data = new Data();

        new Thread(()-> {for (int i = 0; i < 10; i++)data.add();},"A").start();
        new Thread(()-> {for (int i = 0; i < 10; i++)data.cut();},"B").start();

        new Thread(()-> {for (int i = 0; i < 10; i++)data.add();},"C").start();
        new Thread(()-> {for (int i = 0; i < 10; i++)data.cut();},"D").start();

        /*new Thread(()-> {for (int i = 0; i < 10; i++)data.add();},"E").start();
        new Thread(()-> {for (int i = 0; i < 10; i++)data.cut();},"F").start();*/
    }

}

class Data{

    private int num = 0;

    //加
    public synchronized void add(){
        while (num!=0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num++;
        System.out.println(Thread.currentThread().getName()+"-->"+num);
        //通知其它线程，+1完毕
        this.notifyAll();
    }

    //键
    public synchronized void cut(){
        if (num==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num--;
        System.out.println(Thread.currentThread().getName()+"-->"+num);
        //通知其它线程，-1完毕
        this.notifyAll();
    }

}


