package test;

public class ThreadDemo02 implements Runnable {

    private static int ticket = 100;
    @Override
    public void run() {
        while (ticket>0){
            show();
        }
    }
    private synchronized void show(){
        if(ticket>0){
            System.out.println(Thread.currentThread().getName()+"+++++++++"+ticket);
            ticket--;
        }

    }
    
    public static void main(String[] args) {
        ThreadDemo02 td = new ThreadDemo02();
        new Thread(td,"线程A").start();
        new Thread(td,"线程B").start();
        new Thread(td,"线程C").start();
    }
}