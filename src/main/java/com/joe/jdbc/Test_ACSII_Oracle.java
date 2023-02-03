package com.joe.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

/**
 * @author xqh
 * @Title: ascii字符集
 * @Description:
 * @date 2022/9/3014:37
 */
public class Test_ACSII_Oracle {

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //定义数据库连接地址
    public static final String DBURL = "jdbc:wrap-jdbc:filters=encoding:jdbc:oracle:thin:@//192.168.0.233:1521/helowin";
    public static final String DBUSER = "test";
    public static final String DBPASS = "123456";
    public static void main(String[] agrs) throws Exception{
        String sql = "select code,fee_type from t_fee_type";

        Properties props = new Properties();
        props.setProperty("serverEncoding","ISO-8859-1");
        props.setProperty("clientEncoding","GBK");
        props.put("user", DBUSER);
        props.put("password", DBPASS);
        Connection conn = (Connection) DriverManager.getConnection(DBURL,props);
        PreparedStatement ps = (PreparedStatement)conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE);
        //Statement stmt = conn.createStatement();
        //ps.setNString(1,"病程记录");
        ResultSet rs = ps.executeQuery();
        List<Map<String, Object>> mapList = print(rs);
        for (Map<String, Object> objectMap : mapList) {
            System.out.println(objectMap);
        }
        //关闭资源
        if(rs!=null){rs.close();}
        if(ps!=null){ps.close();}
        if(conn!=null){conn.close();}
    }

    public static List<Map<String,Object>> print(ResultSet rs)throws Exception{
        int rowCount = 0;
        long begin = System.currentTimeMillis();
        List<Map<String,Object>> list = new ArrayList<>();
        while (rs.next()){
            rowCount++;
            Map<String,Object> map = new HashMap<>();
            //获取数据
            map.put("code",rs.getString(1));
            //map.put("fee_type2",new String(rs.getString("fee_type").getBytes("ISO-8859-1"),"GBK"));
            map.put("fee_type3",rs.getString(2));
            list.add(map);
        }
        long end = System.currentTimeMillis();
        System.out.println("总共行数："+rowCount);
        System.out.println("耗时："+ (end-begin)/1000+"秒");
        return list;
    }

}
