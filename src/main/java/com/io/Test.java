package com.io;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 使用字符缓冲区读取文件
 */
public class Test {

    public static void main(String[] args) throws Exception{
        //1、创建FileRead对象
        FileReader fr = new FileReader("g:\\com.test.txt");
        BufferedReader br = new BufferedReader(fr);
        //2、读取 第一种
        /*char[] buf = new char[1024];
        int count = 0;
        while ((count=br.read(buf))!=-1){
            System.out.print(new String(buf,0,count));
        }*/
        //3、读取 第二种
        String str = null;
        while ((str=br.readLine())!=null){
            System.out.println(str);
        }
        //4、关闭
        br.close();

    }

}
