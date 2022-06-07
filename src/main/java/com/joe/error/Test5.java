package com.joe.error;

public class Test5 {

    public static void main(String[] args) {
        p_error1();
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
            throw new IllegalArgumentException(e);
        }finally {
            System.out.println("finally...");
        }
    }

}
