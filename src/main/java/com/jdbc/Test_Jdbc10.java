package com.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test_Jdbc10 {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //定义数据库连接地址
    public static final String DBURL = "jdbc:mysql://192.168.0.233:3306/test?useSSL=true&characterEncoding=utf8";
    //数据库用户名
    public static final String DBUSER = "root";
    //数据库密码
    public static final String DBPASS = "root";
    public static void main(String[] agrs) throws Exception{
        String name = "哈哈";
        String sql = "insert into userblob(name,photo) values(?,?)";
        Connection conn = (Connection) DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1,name);
        //插入图片占位符值
        ps.setBlob(2, new FileInputStream("D:\\test.jpg"));

        //执行插入图片
        int executeUpdate = ps.executeUpdate();
        if (executeUpdate>0) {
            System.out.println("success");
        } else {
            System.out.println("failure");
        }
        ps.close();
        conn.close();
    }

}
