package com.joe.ip;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient3 {
    public static void main(String[] args) {
        Socket socket = null;
        FileInputStream fis = null;
        OutputStream os = null;
        try {
            //1、创建Socket对象，它的第一个参数需要的是服务端的IP，第二个参数是服务端的端口
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet, 8888);
            //2、创建一个文件输入流，读取要上传的文件
            fis = new FileInputStream("D:/com.joe.test.jpg");
            //3、获取一个输出流，用于写出要发送的数据
            os = socket.getOutputStream();
            byte[] buffer = new byte[1024];
            int len=0;
            while((len=fis.read(buffer))!=-1){
                //4、写出数据
                os.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//5、释放资源
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}