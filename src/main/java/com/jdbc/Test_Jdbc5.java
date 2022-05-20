package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Scanner;

public class Test_Jdbc5 {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //定义数据库连接地址
    public static final String DBURL = "jdbc:mysql://192.168.0.233:3306/com.test?useSSL=true&characterEncoding=utf8";
    //定义数据库用户名
    public static final String DBUSER = "root";
    //定义数据库密码
    public static final String DBPASS = "root";
    public static void main(String[] agrs) throws Exception{
        //输入模糊查询关键字
        System.out.println("输入姓名模糊查询关键字：");
        Scanner in =new Scanner(System.in);
        String keyWord = in.next();
        String sql = "select id,name,password,age,sex,birthday from t_user where  name like ?";
        //连接数据库
        Connection conn = (Connection) DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        //操作数据库
        PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
        ps.setString(1, "%" + keyWord + "%");
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String password = rs.getString(3);
            int age = rs.getInt(4);
            String sex = rs.getString(5);
            Date d = rs.getDate(6);
            System.out.println(id + ", " + name + ", " + password + ", " + age + ", " + sex + ", " + d);
        }
        rs.close();
        ps.close();
        conn.close();
    }

}
