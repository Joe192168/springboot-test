package io;


import java.io.FileReader;

/**
 * 使用字符流的抽象类读取中文内容
 */
public class FileReadTest {

    public static void main(String[] args) throws Exception{
        //1、创建字符文件流
        FileReader fileReader = new FileReader("g:\\test.txt");
        //2、使用单个字符读取
        /*int data = 0;
        while ((data=fileReader.read())!=-1){
            System.out.print((char)data);
        }*/
        //3、使用自定义缓冲区读取
        char[] buf = new char[1];
        int count = 0;
        while ((count=fileReader.read(buf))!=-1){
            System.out.println(new String(buf,0,count));
        }
        //4、关闭
        fileReader.close();
    }

}
