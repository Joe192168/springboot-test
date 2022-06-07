package com.joe.jni;

import com.sun.jna.Library;
import com.sun.jna.Native;

public class JNATest {

    public interface CLibrary extends Library {
        CLibrary instance = Native.load("H:\\Git\\springboot-com.joe.test\\src\\main\\resources\\NativeAdd", CLibrary.class);
        int add(int x, int y);
    }

    public interface TestLibrary extends Library {
        TestLibrary instance = Native.load("H:\\Git\\springboot-com.joe.test\\src\\main\\resources\\TEST", TestLibrary.class);
        double Add(double a, double b);
        double Divide(double a, double b);
    }

    public static void main(String[] args) {
        /*int add = CLibrary.instance.add(1, 2);
        System.out.println("结果："+add);*/

        double sum = TestLibrary.instance.Add(10, 5);
        double divide = TestLibrary.instance.Divide(10, 5);
        System.out.println("Add(10, 5) = " + sum);
        System.out.println("Divide(10, 5) = " + divide);
    }

}
