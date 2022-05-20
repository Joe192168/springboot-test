package com.jdbc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test_Jdbc11 {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //定义数据库连接地址
    public static final String DBURL = "jdbc:mysql://192.168.0.233:3306/com.test?useSSL=true&characterEncoding=utf8";
    //数据库用户名
    public static final String DBUSER = "root";
    //数据库密码
    public static final String DBPASS = "root";
    public static void main(String[] agrs) throws Exception{
        int id = 2;
        String sql = "select name,photo from userblob";
        Connection conn = (Connection) DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        PreparedStatement ps = (PreparedStatement)conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            String name = rs.getString(1);
            System.out.println("姓名: " + name);
            InputStream is = rs.getBinaryStream(2);
            File f = new File("D:\\qq.jpg");
            FileOutputStream fos = new FileOutputStream(f);
            byte[] arr = new byte[1024];
            int len = 0;
            while((len = is.read(arr)) != -1) {
                fos.write(arr, 0, len);
            }
            is.close();
            fos.close();
        }
        rs.close();
        ps.close();
        conn.close();
    }

}
