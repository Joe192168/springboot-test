package com.joe.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test_Jdbc7 {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    //数据库连接地址
    public static final String DBURL = "jdbc:mysql://192.168.0.233:3306/com.joe.test?useSSL=true&characterEncoding=utf8";
    //数据库用户名
    public static final String DBUSER = "root";
    //数据库密码
    public static final String DBPASS = "root";
    public static void main(String[] agrs) throws Exception{
        //定义名称
        String name = "张三";
        //定义备注
        File f = new File("d:\\com.joe.sql.txt");
        FileInputStream fis = new FileInputStream(f);
        //连接数据库
        Connection conn = (Connection) DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        //Sql语句
        String sql = "insert into userclob(name,note) values(?,?)";
        //操作数据库
        PreparedStatement ps = (PreparedStatement)conn.prepareStatement(sql);
        //设置
        ps.setString(1, name);
        ps.setAsciiStream(2, fis, (int)f.length());
        int index = ps.executeUpdate();
        System.out.println(index + "条插入成功!");
        ps.close();
        conn.close();
    }

}
