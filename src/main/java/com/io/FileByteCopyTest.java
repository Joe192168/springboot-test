package com.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 使用文件字节流实现文件复制
 */
public class FileByteCopyTest {

    public static void main(String[] args) throws Exception {
        //1、创建流
        //2、创建输入流实例
        FileInputStream fis = new FileInputStream("g:\\001.jpg");
        //3、创建输出流实例
        FileOutputStream fos = new FileOutputStream("g:\\002.jpg");
        //4、创建字节流缓冲区,边读，边写
        byte[] buf = new byte[1024];
        //5、声明变量，表示实际读取字节个数的
        int count = 0;
        while ((count=fis.read(buf))!=-1){
            fos.write(buf,0,count);
        }
        //6、关闭
        fis.close();
        fos.close();
    }

}
