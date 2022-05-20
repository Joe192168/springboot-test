package com.io;

import java.io.PrintWriter;

/**
 * 使用打印流
 */
public class PrintWriterTest {

    public static void main(String[] args) throws Exception{
        //1、创建PrintWriter
        PrintWriter pw = new PrintWriter("g:\\print.txt");
        //2、打印内容
        pw.println(91);
        pw.println(1.02);
        pw.println("测试打印 ");
        pw.close();
    }
}
