package com.error;

public class Test6 {

    public static void main(String[] args) {
        double x = abs(-125.45);
        assert x >=0 : "x must >=0";
        System.out.println(x);
    }

    public static double abs(double d){
        return d>0?d:-d;
    }

}
