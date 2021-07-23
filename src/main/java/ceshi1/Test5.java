package ceshi1;

public class Test5 {

    public static void main(String[] args) {
        p_error2();
    }

    public static void p_error1(){
        try {
            p_error2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void p_error2(){
        p_error3();
    }

    public static void p_error3(){
        try {
            Integer.parseInt(null);
        } catch (NumberFormatException e) {
            //保留原始异常信息
            throw new IllegalArgumentException(e);
        }finally {
            //就算throw new新的异常，finall也是会执行的
            System.out.println("end");
        }
    }

}