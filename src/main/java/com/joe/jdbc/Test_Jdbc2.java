package com.joe.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test_Jdbc2 {

    static {
        //加载驱动try i
        try {
            Class.forName( "com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://192.168.0.233:3306/com.joe.test?useSSL=true&characterEncoding=utf8";
        String db_user = "root" ;
        String db_password = "root";
        //创建连接
        Connection conn = (Connection) DriverManager.getConnection(url,db_user,db_password);
        //通过Connection获取Statement
        Statement stmt = (Statement)conn.createStatement();
        String name = "张三";
        String password = "123";
        int age = 15;
        String sex = "男";
        String birthday = "2020-07-06" ;
        String sql = "insert into t_user(name , password , age,sex,birthday) values('" +
                name +"' , '" + password + "' ," + age +" , '"+sex + "', '" + birthday +"')";
        //执行Sal语句
        int index = stmt.executeUpdate(sql);
        System. out.println(index +"条记录受影响.");
        stmt.close();//关闭资源
        conn.close();
    }

}
