package com.ip;

public class Student {
    public static void main(String[] args) {
        new Thread(new UDPSender2("127.0.0.1",8888)).start();
        new Thread(new UDPReceiver2(7777,"老师")).start();
    }
}
