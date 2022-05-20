package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test_Jdbc12 {

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
        String sql = "select id,name,password,age,sex,birthday from t_user";
        Connection conn = (Connection) DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        PreparedStatement ps = (PreparedStatement)conn.prepareStatement(sql,
                ResultSet.TYPE_SCROLL_SENSITIVE,//设置滚动
                ResultSet.CONCUR_UPDATABLE);//设置可以更新
        ResultSet rs = ps.executeQuery();
        rs.absolute(1);//指针移动到第一条记录
        //输出记录
        print(rs,1);
        //关闭资源
        rs.close();
        ps.close();
        conn.close();
    }

    public static void print(ResultSet rs,int row)throws Exception{
        if(row>0){
            rs.next();//由前向后
        }else{
            rs.previous();//由后向前
        }
        //获取数据
        int id = rs.getInt(1);
        String name = rs.getString(2);
        String password = rs.getString(3);
        System.out.println("编号："+id);
        System.out.println("姓名："+name);
        System.out.println("密码："+password);

    }

}
