package com.joe.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test_Jdbc15 {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //定义数据库连接地址
    public static final String DBURL = "jdbc:mysql://192.168.0.233:3306/com.joe.test?useSSL=true&characterEncoding=utf8";
    public static final String DBUSER = "root";
    public static final String DBPASS = "root";
    public static void main(String[] agrs) throws Exception{
        String sql = "insert into t_user(name,password,age,sex,birthday) values(?,?,?,?,?)";
        Connection conn = (Connection) DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        PreparedStatement ps = (PreparedStatement)conn.prepareStatement(sql,
                ResultSet.TYPE_SCROLL_SENSITIVE,//设置滚动
                ResultSet.CONCUR_UPDATABLE);//设置可以更新
        for (int i = 0; i < 10; i++) {
            ps.setString(1, "张"+i);  //从1开始
            ps.setString(2, "P"+i);
            ps.setInt(3, 10+i);
            ps.setString(4, i%2==0?"男":"女");
            ps.setDate(5, new java.sql.Date(new java.util.Date().getTime()));
            ps.addBatch();
        }
        //执行的条数
        int[] ints = ps.executeBatch();
        System.out.println("总共插入："+ints.length+"条数据");
        //关闭资源
        ps.close();
        conn.close();
    }

}
