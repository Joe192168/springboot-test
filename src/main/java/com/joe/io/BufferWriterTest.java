package com.joe.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * 使用字节缓冲流写入
 */
public class BufferWriterTest {

    public static void main(String[] args) throws Exception{
        //1、创建字节输入流对象
        FileOutputStream fos = new FileOutputStream("g:\\com.joe.test.txt");
        //2、创建字节缓冲流对象
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        //3、写入数据
        String str = "今天天气咋样";
        bos.write(str.getBytes());
        //4、关闭
        bos.close();
    }
}
