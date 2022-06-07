package com.joe.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class Test_Jdbc3 {

    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://192.168.0.233:3306/com.joe.test?useSSL=true&characterEncoding=utf8" ;
        String db_user = "root" ;
        String db_password = "root";
        //com.joe.sql.txt ：select * from t_user
        BufferedReader br = new BufferedReader(new FileReader("d:\\com.joe.sql.txt"));
        String sql = br.readLine();
        Connection conn = (Connection) DriverManager.getConnection(url,db_user,db_password);
        Statement stmt = (Statement)conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString( "name" );
            String password = rs.getString("password");
            int age = rs.getInt( "age");
            String sex = rs.getString( "sex");
            Date d = rs.getDate("birthday");
            System.out.println( "id: " +id + "; ");
            System. out.println( "name: " + name + "; ");
            System. out.println("password: " + password + "; ");
            System. out.println( "age: " + age + "; ");
            System.out.println( "sex: " +sex + "; ");
            System . out.println( "birthday: " +d + " ; n");
        }
        rs.close();
        stmt.close();
        conn.close();
    }

}
