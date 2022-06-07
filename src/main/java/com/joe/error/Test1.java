package com.joe.error;

import java.io.FileReader;
import java.io.IOException;

public class Test1 {

    public static void main(String[] args) throws IOException {
        /*String str = "a123";
        int n = Integer.parseInt(str);*/

        FileReader reader = new FileReader("d:\\aa.txt");
        int num = 0;
        while ((num=reader.read())!=-1){
            System.out.println((char)num);
        }

    }

}
