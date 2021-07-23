package juc2;

import java.util.concurrent.CountDownLatch;

//计数器
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        //总量为3，必须要执行任务的时候，在使用
        CountDownLatch countDownLatch = new CountDownLatch(3);

        for (int i = 1; i <= 3; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"出门");
                countDownLatch.countDown();//数量-1
            },String.valueOf(i)).start();
        }
        //等待计数器归零，然后在往下执行
        countDownLatch.await();
        System.out.println("关门");
    }

}
