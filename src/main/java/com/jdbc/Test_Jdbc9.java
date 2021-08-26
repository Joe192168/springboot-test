package com.jdbc;

import java.sql.*;
import java.util.Scanner;

public class Test_Jdbc9 {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //定义数据库连接地址
    public static final String DBURL = "jdbc:mysql://192.168.0.233:3306/test?useSSL=true&characterEncoding=utf8";
    //定义数据库用户名
    public static final String DBUSER = "root";
    //定义数据库密码
    public static final String DBPASS = "root";
    public static void main(String[] agrs) throws Exception{
        //输入模糊查询关键字
        System.out.println("输入序列号：");
        Scanner in =new Scanner(System.in);
        int id = in.nextInt();
        String sql = "select name , note from userclob where id = ?";
        //连接数据库
        Connection conn = (Connection) DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        //操作数据库
        PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            String name = rs.getString(1);
            Clob clob = rs.getClob(2);
            System.out.println(name+","+clob.getSubString(1,(int)clob.length()));
        }
        rs.close();
        ps.close();
        conn.close();
    }

}
