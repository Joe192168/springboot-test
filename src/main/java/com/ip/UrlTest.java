package com.ip;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlTest {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/index.jsp?username=Tom&password=123456");
        System.out.println(url.getProtocol());//获取协议名
        System.out.println(url.getHost());//获取主机名
        System.out.println(url.getPort());//获取端口号
        System.out.println(url.getPath());//获取文件路径
        System.out.println(url.getFile());//获取文件名
        System.out.println(url.getQuery());//获取查询名
    }
}
