package com.joe.jdbc;

import org.apache.commons.codec.binary.Base64;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Test_Oracle {

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //定义数据库连接地址
    public static final String DBURL = "jdbc:oracle:thin:@192.168.0.232:1521:edw";
    public static final String DBUSER = "inmon";
    public static final String DBPASS = "jhsz0603";
    public static void main(String[] agrs) throws Exception{
        String sql = "select CONTENT,EDITLOG,CONTENTTEXT from BZ_DOC_LOG_XML";
        Connection conn = (Connection) DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        PreparedStatement ps = (PreparedStatement)conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE);
        //Statement stmt = conn.createStatement();
        //ps.setNString(1,"病程记录");
        ResultSet rs = ps.executeQuery();
        List<Map<String, Object>> mapList = print(rs);

        String inSql = "insert into BZ_DOC_LOG_XML(TITLE,CREATOR,CONTENT,EDITLOG,CONTENTTEXT) " +
                " values(?,?,?,?,?)";
        PreparedStatement pstat = conn.prepareStatement(inSql);
        for (Map<String, Object> map : mapList) {
            //pstat.setNString(1,map.get("TITLE"));
            //pstat.setNString(2,map.get("CREATOR"));
            pstat.setNString(1,map.get("CONTENT").toString());
            pstat.setNString(2,map.get("EDITLOG").toString());
            pstat.setNString(3,map.get("CONTENTTEXT").toString());
            pstat.addBatch();
        }
        pstat.executeBatch(); //批量执行预定义SQL
        conn.commit();//提交事务
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
            //String TITLE = rs.getString(1);
           // String CREATOR = rs.getString(2);
            Blob CONTENT_Clob = rs.getBlob(1);
            //String CONTENT_clobToString = ClobToString(CONTENT_Clob);
            Clob EDITLOG_Clob = rs.getClob(2);
            String EDITLOG_clobToString = ClobToString(EDITLOG_Clob);
            Clob CONTENTTEXT_Clob = rs.getClob(3);
            String CONTENTTEXT_clobToString = ClobToString(CONTENTTEXT_Clob);
            //map.put("TITLE",TITLE);
            //map.put("CREATOR",CREATOR);
            map.put("CONTENT",CONTENT_Clob);
            map.put("EDITLOG",EDITLOG_clobToString);
            map.put("CONTENTTEXT",CONTENTTEXT_clobToString);
            list.add(map);
        }
        long end = System.currentTimeMillis();
        System.out.println("总共行数："+rowCount);
        System.out.println("耗时："+ (end-begin)/1000+"秒");
        return list;
    }

    public static String ClobToString(Clob clob) {
        String clobStr = "";
        Reader is = null;
        try {
            is = clob.getCharacterStream();
            BufferedReader br = new BufferedReader(is);
            String s = null;
            s = br.readLine();
            StringBuffer sb = new StringBuffer();
            while (s != null) {
                sb.append(s);
                s = br.readLine();
            }
            clobStr = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clobStr;
    }

    /**
     * 使用org.apache.commons.codec.binary.Base64压缩字符串
     * @param str 要压缩的字符串
     * @return
     */
    public static String compress(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }//加入Java开发交流君样：756584822一起吹水聊天
        return Base64.encodeBase64String(str.getBytes());
    }

    /**
     * 使用org.apache.commons.codec.binary.Base64解压缩
     *
     * @param compressedStr 压缩字符串
     * @return
     */
    public static byte[] uncompress(String compressedStr) {
        if (compressedStr == null) {
            return null;
        }
        return Base64.decodeBase64(compressedStr);
    }


    /**
     * 使用gzip压缩字符串
     * @param str 要压缩的字符串
     * @return
     */
    public static String compressZip(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = null;
        try {
            gzip = new GZIPOutputStream(out);
            gzip.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (gzip != null) {
                try {
                    gzip.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }//加入Java开发交流君样：756584822一起吹水聊天
            }
        }
        return new sun.misc.BASE64Encoder().encode(out.toByteArray());
    }

    /**
     * 使用gzip解压缩
     * @param compressedStr 压缩字符串
     * @return
     */
    public static String uncompressZip(String compressedStr) {
        if (compressedStr == null) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = null;
        GZIPInputStream ginzip = null;
        byte[] compressed = null;
        String decompressed = null;
        try {
            compressed = new sun.misc.BASE64Decoder().decodeBuffer(compressedStr);
            in = new ByteArrayInputStream(compressed);
            ginzip = new GZIPInputStream(in);
            byte[] buffer = new byte[1024];
            int offset = -1;
            while ((offset = ginzip.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
            }
            decompressed = out.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ginzip != null) {
                try {
                    ginzip.close();
                } catch (IOException e) {
                }//加入Java开发交流君样：756584822一起吹水聊天
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
        }
        return decompressed;
    }


}
