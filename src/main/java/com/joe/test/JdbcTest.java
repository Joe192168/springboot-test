package com.joe.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class JdbcTest {

    public static void main(String[] args) throws Exception {
        testTime();
    }

    public static void testTime() throws Exception {
        String url = "jdbc:oracle:thin:@//192.168.0.232:1521/edw";
        String user = "INMON";
        String password = "jhsz0603";
        String sql = "SELECT * FROM A";

        TimeZone timeZone = TimeZone.getTimeZone("ShangHai");
        TimeZone.setDefault(timeZone);

        Class.forName("oracle.jdbc.driver.OracleDriver");
        //根据数据库连接字符，名称，密码给conn赋值
        Connection conn = DriverManager.getConnection(url, user, password);

        Statement statement = conn.createStatement();  //创建数据库执行对象

        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getObject("aa"));
           /* Date aa1 = resultSet.getDate("aa");

            Object aa = resultSet.getObject("aa");

            DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.S");
            System.out.println(sdf.parse(aa.toString()));*/
            //System.out.println(resultSet.getTimestamp("ooo"));
        }

    }

}
