package juc2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    public static void main(String[] args) {
        //等7个人齐了就可以救爷爷
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("葫芦娃救爷爷");
        });

        for (int i = 1; i <= 7; i++) {
            final int temp = i;
            new Thread(()->{
                System.out.println("第"+temp+"葫芦娃，到了");
                try {
                    //等到7个人到齐了，就可以开始就爷爷了
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
