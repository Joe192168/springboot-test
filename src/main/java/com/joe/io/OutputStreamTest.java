package com.joe.io;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * 使用转换流写入文件
 */
public class OutputStreamTest {

    public static void main(String[] args) throws Exception{
        //1、创建字节输出流对象
        FileOutputStream fos = new FileOutputStream("g:\\writer.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");
        //2、写入内容
        for (int i = 0; i < 10; i++) {
            osw.write("测试一下\r\n");
        }
        //3、关闭
        osw.close();

    }

}
