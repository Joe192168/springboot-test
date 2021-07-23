package io;

import java.io.FileInputStream;

public class InputTest {

    public static void main(String[] args) throws Exception{
        //1、创建字节流对象
        FileInputStream fis = new FileInputStream("g:\\test.txt");//内容：快乐学习
        //2、读取内容
        int data = 0;
        while ((data=fis.read())!=-1){
            System.out.print((char) data);
        }
        //3、关闭
        fis.close();
    }

}
