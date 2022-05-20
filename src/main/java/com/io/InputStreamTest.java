package com.io;

import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 使用转换流读取文件
 */
public class InputStreamTest {

    public static void main(String[] args) throws Exception{
        //1、创建字节流对象
        FileInputStream fis = new FileInputStream("g:\\com.test.txt");
        InputStreamReader isr = new InputStreamReader(fis,"utf-8");
        //2、读取
        int data = 0;
        while ((data=isr.read())!=-1){
            System.out.print((char)data);
        }
        //3、关闭
        isr.close();
    }
}
