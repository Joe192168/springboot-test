package test;

public class Print {
    
    int i = 1;

    public synchronized void increment() throws InterruptedException {
        if (i % 2 == 0) {
            this.wait();
        }
        System.out.println(Thread.currentThread().getName() +":" + i);
        i++;
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        if (i % 2 != 0) {
            this.wait();
        }
        System.out.println(Thread.currentThread().getName() + ":" + i);
        i++;
        this.notifyAll();
    }

    public static void main(String[] args) {
        Print print = new Print();
        new Thread(() -> {
            for (int i = 1; i <= 50; i++) {
                try {
                    print.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 1; i <= 50; i++) {
                try {
                    print.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}