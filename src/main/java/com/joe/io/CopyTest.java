package com.joe.io;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * 使用FileReader和FileWriter字符流复制文件
 */
public class CopyTest {

    public static void main(String[] args) throws Exception{
        //1、创建FileReader对象
        FileReader fr = new FileReader("g:\\com.joe.test.txt");
        //2、创建FileWriter对象
        FileWriter fw = new FileWriter("g:\\test1.txt");
        //3、读写
        int data = 0;
        while ((data=fr.read())!=-1){
            fw.write(data);
            fw.flush();
        }
        //4、关闭
        fr.close();
        fw.close();
    }

}
