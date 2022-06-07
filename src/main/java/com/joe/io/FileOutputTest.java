package com.joe.io;

import java.io.FileOutputStream;

public class FileOutputTest {

    public static void main(String[] args) throws Exception {
        //1、创建FileOutputStream对象，并传入文件路径
        //第一种，会覆盖
        //FileOutputStream filter = new FileOutputStream("g:\\com.joe.test.txt");
        //第二种，自动追加
        FileOutputStream filter = new FileOutputStream("g:\\com.joe.test.txt",true);
        //2、写入内容
        byte[] buf = new byte[1024];
        String str = "abc";
        buf = str.getBytes();
        filter.write(buf);
        //3、关闭
        filter.close();
    }

}
