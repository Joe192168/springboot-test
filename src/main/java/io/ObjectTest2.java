package io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * 反序列化
 */
public class ObjectTest2 {

    public static void main(String[] args) throws Exception{
        //1、创建字节输入流对象
        FileInputStream fis = new FileInputStream("g:\\obj.bin");
        //2、创建对象缓冲流对象
        ObjectInputStream ois = new ObjectInputStream(fis);
        User user = (User) ois.readObject();
        ois.close();
        System.out.println(user);
    }

}
