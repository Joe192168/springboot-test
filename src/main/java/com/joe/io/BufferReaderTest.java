package com.joe.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * 使用BufferedInputStream字节缓冲流读取
 */
public class BufferReaderTest {

    public static void main(String[] args) throws Exception{
        //1、创建FileInputStream实例对象
        FileInputStream fis = new FileInputStream("g:\\com.joe.test.txt");
        //2、创建缓冲区
        BufferedInputStream bis = new BufferedInputStream(fis);
        //3、读取
        /*int data = 0;
        while ((data=bis.read())!=-1){
            System.out.print((char) data);
        }*/
        //自己创建缓冲区
        int data = 0;
        byte[] buf = new byte[1024];
        while ((data=bis.read(buf))!=-1){
            System.out.print(new String(buf,0,data));
        }
        //4、关闭
        bis.close();
    }

}
