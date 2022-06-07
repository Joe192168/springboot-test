package com.joe.jni;

public class Sample
 {
     public static void main(String[] args)
     {
         System.loadLibrary("NativeAdd");

         NativeAdd na = new NativeAdd();

         System.out.println("3 + 4 = " + na.add(3, 4));
     }
 }
 
 class NativeAdd
 {
     public native int add(int x, int y);
 }

class NativeMethodTest
{
    public native int intMethod(int n);
    public native boolean booleanMethod(boolean bool);
    public native String stringMethod(String text);
    public native int intArrayMethod(int[] intArray);
}