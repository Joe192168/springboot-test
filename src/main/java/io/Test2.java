package io;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * 使用字符缓冲区写入文件
 */
public class Test2 {

    public static void main(String[] args) throws Exception{
        //1、创建FileWriter对象
        FileWriter fw = new FileWriter("g:\\writer.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        //2、写入
        for (int i = 1; i <= 10; i++) {
            bw.write("写入成功，第"+i+"个");
            bw.newLine();//换行符，Windows：\r\n和liunx：\n不一样
            //bw.flush();
        }
        //3、关闭
        bw.close();

    }

}
