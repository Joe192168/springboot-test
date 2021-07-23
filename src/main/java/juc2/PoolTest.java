package juc2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//线程池
public class PoolTest {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();//单个线程池
        //ExecutorService threadPool = Executors.newFixedThreadPool(3);//创建一个固定大小的线程池
        //ExecutorService threadPool = Executors.newCachedThreadPool();//可伸缩，遇强则强，遇弱则弱

        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"--> OK");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

}
