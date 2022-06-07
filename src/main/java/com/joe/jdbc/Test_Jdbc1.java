package com.joe.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test_Jdbc1 {

    public static void main(String[] args) throws Exception {
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //创建链接
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.0.233?useSSL=true", "root", "root");
        System.out.println(conn);
        //关闭数据库
        conn.close();

    }

}
