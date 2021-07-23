package io;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {

    public static void main(String[] args) {
        jvmPara();
        //jdbcTest();
        //jdbcTest2();
        //jdbcTest3();
        //jdbcTest4();
        //jdbcTest5();
        //jdbcTest6();
        //jdbcTest7();
    }

    //打印JVM参数
    private static void jvmPara(){
        Properties properties = System.getProperties();
        //打印JVM参数
        properties.list(System.out);
    }

    //打印自定义.properties文件中的值
    private static void jdbcTest() {
        Properties properties = new Properties();
        FileInputStream fis = null;
        try {
            //使用绝对路径
            fis = new FileInputStream("H:\\Git\\springboot-test\\src\\jdbc.properties");
            InputStream inputStream = new BufferedInputStream(fis);
            properties.load(inputStream);
            properties.list(System.out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //打印自定义.properties文件中的值,使用propertyNames 输出
    private static void jdbcTest2() {
        Properties properties = new Properties();
        try {
            //使用相对路径
            //InputStream input=PropertiesTest.class.getClass().getResourceAsStream("/jdbc.properties");
            //推荐使用类加载器方式
            InputStream input=PropertiesTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(input);
            //properties.list(System.out);
            Enumeration<String> enumeration = (Enumeration<String>) properties.propertyNames();
            while (enumeration.hasMoreElements()) {
                //这是key
                String key = enumeration.nextElement();
                String value = properties.getProperty(key);
                System.out.println(key+"="+value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取值
    private static void jdbcTest3() {
        Properties properties = new Properties();
        try {
            //推荐使用类加载器方式
            InputStream input=PropertiesTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(input);
            System.out.println(properties.getProperty("jdbc.url"));
            System.out.println(properties.getProperty("jdbc.url1", "没有该key的值"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //写入properties文件值
    private static void jdbcTest4() {
        Properties properties = new Properties();
        try {
            //推荐使用类加载器方式
            InputStream input=PropertiesTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(input);
            //增加值
            properties.setProperty("name","张三");
            properties.setProperty("age","12");
            properties.setProperty("sex","男");

            OutputStream os = new FileOutputStream("g:\\jdbc.properties");
            properties.store(os,"填充数据");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //写入properties文件值，解决乱码问题
    private static void jdbcTest5() {
        Properties properties = new Properties();
        try {
            //推荐使用类加载器方式
            InputStream input=PropertiesTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(new InputStreamReader(input,"utf-8"));
            //增加值
            properties.setProperty("name","张三");
            properties.setProperty("age","12");
            properties.setProperty("sex","男");

            OutputStream os = new FileOutputStream("g:\\jdbc.properties");
            OutputStreamWriter osw = new OutputStreamWriter(os,"utf-8");
            properties.store(osw,"填充数据");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //导出到 .xml 配置文件
    private static void jdbcTest6() {
        Properties properties = new Properties();
        try {
            //增加值
            properties.setProperty("name","张三");
            properties.setProperty("age","12");
            properties.setProperty("sex","男");

            OutputStream os = new FileOutputStream("g:\\jdbc.xml");
            properties.storeToXML(os,"填充xml数据","utf-8");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //加载xml配置文件,并打印
    private static void jdbcTest7() {
        Properties properties = new Properties();
        try {
            InputStream is = new BufferedInputStream(new FileInputStream("g:\\jdbc.xml"));
            properties.loadFromXML(is);
            properties.list(System.out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
