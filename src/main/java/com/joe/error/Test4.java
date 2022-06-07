package com.joe.error;

public class Test4 {

    public static void main(String[] args) {
        transformation("a");
    }

    static void transformation(String str){
        try {
            int n = Integer.parseInt(str);
            int m = 100 / n;
        } catch (NumberFormatException | ArithmeticException e){
            System.out.println(e);
        }finally {
            System.out.println("执行完毕");
        }
    }

}
