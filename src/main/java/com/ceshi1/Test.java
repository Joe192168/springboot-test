package com.ceshi1;

public class Test  {
    private Integer num = 0;

    public void produce() throws InterruptedException {
        if(num<=0){
            System.out.println("生产者生产了一个,目前"+ ++num);
            this.notify();
        }else{
            this.wait();
        }

    }

    public void use() throws InterruptedException {
        if(num>0){
            System.out.println("消费者消费了一个,剩余"+--num);
            this.notify();
        }else {
            this.wait();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();

        Thread t1 = new Thread(new produce(test));
        Thread t2 = new Thread(new consumer(test));

        t1.start();
        t2.start();

    }

}
class consumer implements Runnable{
    private Test test;

    public consumer(Test test){
        this.test = test;
    }

    @Override
    public void run() {
        while(true){
            synchronized (test){
                try {
                    test.use();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class produce implements Runnable{
    private Test test;

    public produce(Test test){
        this.test = test;
    }

    @Override
    public void run() {
        while(true){
            synchronized (test){
                try {
                    test.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}