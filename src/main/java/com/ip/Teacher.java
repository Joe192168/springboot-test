package com.ip;

public class Teacher {
    public static void main(String[] args) {
        new Thread(new UDPSender2("127.0.0.1",7777)).start();
        new Thread(new UDPReceiver2(8888,"学生")).start();
    }
}
