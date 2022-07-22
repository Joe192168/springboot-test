package com.joe.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionJDBC {

    //驱动程序就是之前在classpath中配置的JDBC的驱动程序的JAR包中
    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
    //连接地址是由各个数据库生产商单独提供的，所以需要单独记住
    public static final String DBURL = "jdbc:mysql://192.168.0.233:3306/test";
    //连接数据库的用户名
    public static final String DBUSER = "root";
    //连接数据库的密码
    public static final String DBPASS = "123456";


    public static void main(String[] args) throws Exception {
        //表示数据库的连接对象
        Connection con = null;
        //1、使用CLASS 类加载驱动程序 ,反射机制的体现
        Class.forName(DBDRIVER);
        //2、连接数据库
        con = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        System.out.println(con);
        con.close(); // 3、关闭数据库
    }  
}