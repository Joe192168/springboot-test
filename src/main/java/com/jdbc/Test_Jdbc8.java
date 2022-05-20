package com.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Test_Jdbc8 {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    //数据库连接地址
    public static final String DBURL = "jdbc:mysql://192.168.0.233:3306/com.test?useSSL=true&characterEncoding=utf8";
    //数据库用户名
    public static final String DBUSER = "root";
    //数据库密码
    public static final String DBPASS = "root";
    public static void main(String[] agrs) throws Exception{
        int id = 1;
        String sql = "select id,name,note from userclob where id = ?";
        //连接数据库
        Connection conn = (Connection) DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        //操作数据库
        PreparedStatement ps = (PreparedStatement)conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            int iud = rs.getInt(1);
            String naem = rs.getString(2);
            InputStream is = rs.getAsciiStream(3);
            StringBuffer note = new StringBuffer();
            Scanner snote = new Scanner(is);
            snote.useDelimiter("\r\n");
            while(snote.hasNextLine()) {
                note.append(snote.next()).append("\n");
            }
            System.out.println("内容: " + note);
            is.close();
        }
        rs.close();
        ps.close();
        conn.close();
    }

}
