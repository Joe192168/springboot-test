package single;

//饿汉式单列
public class Hungry {

    public Hungry(){

    }

    private static final Hungry hungry = new Hungry();

    public static Hungry getInstance(){
        return hungry;
    }

}
