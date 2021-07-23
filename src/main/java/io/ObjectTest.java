package io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化操作
 */
public class ObjectTest {

    public static void main(String[] args) throws Exception{
        //1、创建字节输出流
        FileOutputStream fos = new FileOutputStream("g:\\obj.bin");
        //2、创建对象缓冲流
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (int i = 0; i < 3; i++) {
            User user = new User();
            user.setId(i);
            user.setName("测试:"+i);
            user.setAge(1+i);
            oos.writeObject(user);
        }
        oos.close();
    }

}
