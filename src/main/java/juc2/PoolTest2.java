package juc2;

import java.util.concurrent.*;

//线程池 模拟银行办理业务
public class PoolTest2 {

    public static void main(String[] args) {
        //自定义线程池
        //最大线程到底如何定义
        //1、CPU 密集型：几核，就是几，可以保持CPU的效率最高
        //2、IO  密集型：> 判断程序中十分耗资源IO线程
        //程序  15个大型任务，io十分占用资源

        //获取CPU的最大核数
        System.out.println(Runtime.getRuntime().availableProcessors());

        ExecutorService threadPool = new ThreadPoolExecutor(
                2,//核心线程大小
                5,//最大核心线程大小
                3,//超时了，不调用就会释放
                TimeUnit.SECONDS,//超时单位
                new LinkedBlockingDeque<>(3),//阻塞队列
                Executors.defaultThreadFactory(),//线程工厂
                new ThreadPoolExecutor.AbortPolicy());//4种拒绝策略之一

        try {
            //最大承载：Deque+max
            //1、AbortPolicy : 中止策略 银行满了，超出了最大柜台办理，不处理业务，抛出异常 RejectedExecutionException
            //2、CallerRunsPolicy : 呼叫者运行策略 哪来的那里，主线程main 不会抛出异常
            //3、DiscardPolicy : 丢弃策略 队列满了，丢弃，不会抛出异常
            //4、DiscardOldestPolicy : 放弃最旧的策略 尝试和最早的线程进行竞争，如果没有结束，就丢弃
            for (int i = 0; i < 9; i++) {
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