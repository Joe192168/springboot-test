package com.wait;

//模拟生产者和消费者  -->管理法
public class TestPc {

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        new Producer(warehouse).start();
        new Consumer(warehouse).start();
    }
}

//生产者
class Producer extends Thread{

    Warehouse warehouse;

    public Producer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    //生产
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            warehouse.push(new FastFood(i));
            System.out.println("生产第："+i+"份");
        }
    }
}

//消费者
class Consumer extends Thread{

    Warehouse warehouse;

    public Consumer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    //消费
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            warehouse.pop();
            System.out.println("消费了，第："+i+"份");
        }
    }
}

//快餐
class FastFood{
    //编号
    int num;

    public FastFood(int num) {
        this.num = num;
    }
}

//缓冲区（仓库）
class Warehouse {
    //初始化快餐数量
    FastFood[] fastFoods = new FastFood[10];
    //计数
    int count = 0;

    //生产者生产产品
    public synchronized void push(FastFood food){
        //如果仓库满了，就得等待消费者消费
        if (count==fastFoods.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没有满，就得生产
        fastFoods[count]=food;
        count++;

        //通知消费者，可以开始消费了
        this.notifyAll();
    }

    //消费者消费产品
    public synchronized FastFood pop(){
        //判断是否能消费
        if (count==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果可以消费
        count--;
        FastFood food = fastFoods[count];

        //吃完了，通知生产者生产
        this.notifyAll();
        return food;

    }


}