package com.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestIP {
    public static void main(String[] args) throws UnknownHostException {
        //InetAdress类表示IP地址

        //获取本机IP
        InetAddress ip = InetAddress.getLocalHost();// ADMINISTRATOR/192.xxx.xxx.xxx
        System.out.println(ip);
        //获得主机名
        System.out.println(ip.getHostName());// ADMINISTRATOR
        //获得IP地址
        System.out.println(ip.getHostAddress());// 192.xxx.xxx.xxx
        //getLocalHost=getHostName+getHostAddress
        System.out.println(InetAddress.getByName("localhost"));
    }
}
