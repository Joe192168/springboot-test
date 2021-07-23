package io;

import java.io.FileInputStream;

public class FilterInputTest {

    public static void main(String[] args) throws Exception {
        //1、创建FileInputStream对象，并指定文件路径
        FileInputStream file = new FileInputStream("g:\\test.txt");
        //2、读取文件
        byte[] buf = new byte[1024];
        int count = 0;
        while ((count = file.read(buf))!=-1){
            System.out.print(new String(buf,0,count));
        }
        //3、关闭
        file.close();
        System.out.println("\n读取完毕！");
    }

}