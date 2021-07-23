package com.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinTest extends RecursiveTask<Long> {

    private Long start;
    private Long end;

    //临界值
    private Long temp = 10000L;

    public ForkJoinTest(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    //计算方法
    @Override
    protected Long compute() {
        if((end-start)>temp){
            Long sum = 0L;
            for (Long i = start; i < end; i++) {
                sum+=i;
            }
            return sum;
        }else{
            //forkjoin递归
            long middle = (start+end)/2;
            ForkJoinTest task1 = new ForkJoinTest(start,middle);
            task1.fork();//拆分任务，把任务压入线程队
            ForkJoinTest task2 = new ForkJoinTest(middle+1,end);
            task2.fork();//拆分任务，把任务压入线程队
            return task1.join()+task2.join();
        }
    }

    //测试1
    public static void test1(){
        Long sum = 0L;
        long start = System.currentTimeMillis();
        for (Long i = 1L; i <= 10_0000_0000; i++) {
            sum+=i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+",时间："+(end-start));
    }

    //测试2
    public static void test2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        //线程池
        ForkJoinPool forkJoinpool = new ForkJoinPool();
        ForkJoinTest task = new ForkJoinTest(0L, 10_0000_0000L);
        //提交任务
        ForkJoinTask<Long> submit = forkJoinpool.submit(task);
        //返回结果
        Long sum = submit.get();
        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+",时间："+(end-start));
    }

    //测试2
    public static void test3(){
        long start = System.currentTimeMillis();
        ForkJoinTest task = new ForkJoinTest(0L, 10_0000_0000L);
        //Stream并行流
        long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+",时间："+(end-start));
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //test1();//时间：6382
        //test2();//时间：5992
        test3();//时间：161
        int a = 10_0000_0000;
        System.out.println(a);
    }

}
