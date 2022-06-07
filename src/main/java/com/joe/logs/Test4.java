package com.joe.logs;

public class Test4 {

    public static void main(String[] args) {
        String str = "F_DRUG_TRANSFER_RECORD66666666555555555555555555555";
        if (str.length()<=10){
            System.out.println(str);
        }else{
            System.out.println(str.substring(0,10));
        }
    }

}
