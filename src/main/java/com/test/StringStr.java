package com.test;

import java.util.Random;

public class StringStr {

    public static void main(String[] args) {

        String str = "test";

        while (true){
            str+=str+new Random().nextInt(8888888)+new Random().nextInt(999999999);
        }
    }
}
