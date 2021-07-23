package io;

import java.io.FileWriter;

/**
 * 使用FileWriter字符写入流中
 */
public class FileWriterTest {

    public static void main(String[] args) throws Exception{
        //1、创建FileWriter对象
        FileWriter fw = new FileWriter("g:\\writer.txt");
        //2、通过字符串写入
        fw.write("你好，中国！");
        fw.flush();
        //3、关闭
        fw.close();
    }
}
