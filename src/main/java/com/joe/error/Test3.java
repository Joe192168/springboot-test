package com.joe.error;

import java.io.FileReader;
import java.io.IOException;

public class Test3 {

    public static void main(String[] args) throws IOException {
        readFile();
    }


    public static void readFile() throws IOException {
        try {
            FileReader reader = new FileReader("d:\\aa.txt");
            int num = 0;
            while ((num=reader.read())!=-1){
                System.out.println((char)num);
            }
        }finally {
            System.out.println("end");
        }
    }

}
