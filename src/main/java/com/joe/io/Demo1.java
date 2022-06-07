package com.joe.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * 使用字节缓冲流写入文件
 */

public class Demo1  {

    public static void main(String[] args) throws Exception{
        //1、创建字节输出缓冲流
        FileOutputStream fos = new FileOutputStream("g:\\shut.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        for (int i = 0; i < 10; i++) {
            bos.write("测试一下写入\r\n".getBytes());//写入缓冲区
//            bos.flush();//刷新缓冲区写到硬盘
        }
        bos.close();
    }

}
