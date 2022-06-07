package com.joe.xml;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JacksonXmlTest {

    public static void main(String[] args) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setDefaultUseWrapper(false);
        //字段为null，自动忽略，不再序列化
        xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //XML标签名:使用骆驼命名的属性名，
        xmlMapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        //设置转换模式
        xmlMapper.enable(MapperFeature.USE_STD_BEAN_NAMING);

        Book book = new Book();
        book.setId(1);
        book.setName("Java核心技术");
        book.setAuthor("张三");
        book.setIsbn("123");
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Web");
        book.setTags(list);
        book.setPubDate("2020-07-03");
        // 实体类 转 xml.
        String xml = xmlMapper.writeValueAsString(book);
        System.out.println("book-xml:" + "\n" + xml);

        // XML to 实体
        Book book1 = xmlMapper.readValue(xml, Book.class);
        System.out.println("xml->book:" + "\n" + book1);
    }

}
