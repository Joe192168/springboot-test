package com.joe.xml;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import java.util.ArrayList;
import java.util.List;

public class JacksonJsonTest {

    public static void main(String[] args) throws Exception {
        ObjectMapper objMapper = new ObjectMapper();
        //字段为null，自动忽略，不再序列化
        objMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //XML标签名:使用骆驼命名的属性名，
        objMapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        //设置转换模式
        objMapper.enable(MapperFeature.USE_STD_BEAN_NAMING);

        Book book = new Book();
        book.setId(1);
        book.setName("Java核心技术");
        book.setAuthor("张三");
        book.setIsbn("123");
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Web");
        book.setTags(list);
        book.setIsFlag(true);
        book.setPubDate("2020-07-03");
        // 实体类 转 xml.
        String json = objMapper.writeValueAsString(book);
        System.out.println("book-json:" + "\n" + json);

        // XML to 实体
        Book book1 = objMapper.readValue(json, Book.class);
        System.out.println("json->book:" + "\n" + book1);
    }

}
