package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test_Jdbc113 {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //定义数据库连接地址
    public static final String DBURL = "jdbc:mysql://192.168.0.233:3306/com.test?useSSL=true&characterEncoding=utf8";
    public static final String DBUSER = "root";
    public static final String DBPASS = "root";
    public static void main(String[] agrs) throws Exception{
        String sql = "select id,name,password,age,sex,birthday from t_user where id = ?";
        Connection conn = (Connection) DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        PreparedStatement ps = (PreparedStatement)conn.prepareStatement(sql,
                ResultSet.TYPE_SCROLL_SENSITIVE,//设置滚动
                ResultSet.CONCUR_UPDATABLE);//设置可以更新
        ps.setInt(1,61);
        ResultSet rs = ps.executeQuery();
        rs.last();//移动到最后一条数
        //打印
        //print(rs);
        //下面的是设置数据
        rs.updateString("name","呵呵");
        rs.updateString("password","123");
        rs.updateInt("age",21);
        rs.updateString("sex","男");
        rs.updateString("birthday","2020-12-10");
        //执行更新操作
        rs.updateRow();
        //关闭资源
        rs.close();
        ps.close();
        conn.close();
    }

    /*public static void print(ResultSet rs)throws Exception{
        rs.next();
        //获取数据
        int id = rs.getInt(1);
        String name = rs.getString(2);
        String password = rs.getString(3);
        System.out.println("编号："+id);
        System.out.println("姓名："+name);
        System.out.println("密码："+password);

    }*/

}