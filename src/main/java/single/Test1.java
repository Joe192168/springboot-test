package single;

public class Test1 {
    public Test1(){
        System.out.println(Thread.currentThread().getName()+"-> ok");
    }

    private static Test1 test1;

    public static Test1 getInstance(){
        if (test1==null){
            synchronized (Test1.class){
                if (test1==null){
                    //极端情况下，如多线程，变量被改变，不能保证原子性操作，增加volatile关键字
                    test1 = new Test1();
                }
            }
        }
        return test1;
    }


    public static void main(String[] args) {
        //单线程，是安全的
        //LazyMan.getInstance();

        //多线程, 不安全
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                System.out.println(Test1.getInstance());
            }).start();
        }
    }
}
