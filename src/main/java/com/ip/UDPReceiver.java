package com.ip;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiver {
    public static void main(String[] args) throws IOException {
        //1、创建一个socket，开放端口
        DatagramSocket socket = new DatagramSocket(9090);
        byte[] buffer = new byte[1024];
        //2、创建一个包接收数据
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        //3、接收数据
        socket.receive(packet);//阻塞式接收
        //将数据包转换为字符串输出
        String msg = new String(packet.getData(), 0, packet.getLength());
        System.out.println(msg);
        //4、释放资源
        socket.close();
    }
}
