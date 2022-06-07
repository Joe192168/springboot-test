package com.joe.jdbc;

import java.sql.*;

public class Test_Jdbc17 {

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
        Connection conn = (Connection) DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        conn.setAutoCommit(false);//设置不自动提交事务
        Statement stmt = conn.createStatement();
        stmt.addBatch("insert into t_user(name,password,age,sex,birthday) values('张1','P1',21,'男','2020-05-10')");
        stmt.addBatch("insert into t_user(name,password,age,sex,birthday) values('张2','P2',22,'男','2020-05-11')");
        Savepoint sp = conn.setSavepoint();
        stmt.addBatch("insert into t_user(name,password,age,sex,birthday) values('张3','P3',23,'男','2020-05-12')");
        stmt.addBatch("insert into t_user(name,password,age,sex,birthday) values('张4','P4',24,'男','2020-05-13')");
        stmt.addBatch("insert into t_user(name,password,age,sex,birthday) values('张5','P5',25,'男','2020-05-14')");
        try {
            int[] ints = stmt.executeBatch();
            conn.rollback(sp);
            conn.commit();
            System.out.println("总共插入："+ints.length+"条数据");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //关闭资源
            stmt.close();
            conn.close();
        }
    }

}
