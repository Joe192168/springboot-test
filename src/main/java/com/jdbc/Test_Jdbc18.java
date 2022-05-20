package com.jdbc;

import java.sql.*;

public class Test_Jdbc18 {

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
        Connection conn = (Connection) DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        DatabaseMetaData dmd = conn.getMetaData();
        System.out.println("数据库名称："+dmd.getDatabaseProductName());
        System.out.println("数据库版本号："+dmd.getDatabaseProductVersion());
        /*ResultSet rs = dmd.getPrimaryKeys(null, null, "t_user");
        while (rs.next()){
            System.out.println("表类别："+rs.getString(1));
            System.out.println("表模式："+rs.getString(2));
            System.out.println("表名称："+rs.getString(3));
            System.out.println("列名称："+rs.getString(4));
            System.out.println("主键序列号："+rs.getString(5));
            System.out.println("主键名称："+rs.getString(6));
        }*/
        String sql = "select * from t_user";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();// 取得数据库的列名
        int columnCount = rsmd.getColumnCount();//获取列的个数
        for (int i = 1; i < columnCount+1; i++) {
            System.out.println("列名称："+rsmd.getColumnName(i));
        }
        //关闭资源
        rs.close();
        conn.close();
    }

}
