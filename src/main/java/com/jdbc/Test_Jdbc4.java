package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test_Jdbc4 {

    static  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    //定义mysql的数据库驱动程序
    //public static final String DBDRIEVER = "com.mysql.jdbc.Driver";
    //定义数据库的连接地址
    public static final String DBURL = "jdbc:mysql://192.168.0.233:3306/test?useSSL=true&characterEncoding=utf8";
    //定义数据库用户名
    public static final String DBUSER = "root";
    //定义数据库密码
    public static final String DBPASS = "root";
    //所有异常抛了
    public static void main(String[] agrs) throws Exception {
        String name = "小明";  //定义姓名
        String password = "123"; //定义密码
        int age = 25;  //定义年龄
        String sex = "男"; //定义性别
        //定义生日
        Date d = new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-21");
        java.sql.Date birthday = new java.sql.Date(d.getTime());
        //定义sql语句t_
        String sql = "insert into t_user(name,password,age,sex,birthday) values(?,?,?,?,?)";
        //数据库的连接
        Connection conn = (Connection) DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        //实例化PreparedStatement对象
        PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
        pstmt.setString(1, name);  //从1开始
        pstmt.setString(2, password);
        pstmt.setInt(3, age);
        pstmt.setString(4, sex);
        pstmt.setDate(5, birthday);
        int index = pstmt.executeUpdate();
        System.out.println(index + "条记录受影响!");
        pstmt.close();
        conn.close();
    }

}
