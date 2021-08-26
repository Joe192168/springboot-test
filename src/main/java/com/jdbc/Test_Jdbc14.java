package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test_Jdbc14 {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //定义数据库连接地址
    public static final String DBURL = "jdbc:mysql://192.168.0.233:3306/test?useSSL=true&characterEncoding=utf8";
    public static final String DBUSER = "root";
    public static final String DBPASS = "root";
    public static void main(String[] agrs) throws Exception{
        String sql = "select id,name,password,age,sex,birthday from t_user where id = ?";
        Connection conn = (Connection) DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        PreparedStatement ps = (PreparedStatement)conn.prepareStatement(sql,
                ResultSet.TYPE_SCROLL_SENSITIVE,//设置滚动
                ResultSet.CONCUR_UPDATABLE);//设置可以更新
        ps.setInt(1,2);
        ResultSet rs = ps.executeQuery();
        rs.last();//移动到最后一条数
        //执行删除操作
        rs.deleteRow();
        //关闭资源
        rs.close();
        ps.close();
        conn.close();
    }

}
