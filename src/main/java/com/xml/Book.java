package com.xml;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.List;

@Data
//设置标签的名字为TOOT，不设置默认就是类名
@JacksonXmlRootElement(localName="book")
@JsonPropertyOrder({"id","name", "author", "isbn","tags","isFlag","pubDate"})
public class Book {

    //元素节点的属性isAttribute为true
    @JacksonXmlProperty(isAttribute = true)
    private long id;
    private String name;
    private String author;
    private String isbn;
    @JacksonXmlElementWrapper(localName="tags")
    @JacksonXmlProperty(localName="tag")
    private List<String> tags;
    @JsonDeserialize(using = BooleanToIntDeserializer.class)
    @JsonSerialize(using = BooleanToIntSerializer.class)
    private Boolean isFlag;
    private String pubDate;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", tags=" + tags +
                ", isFlag=" + isFlag +
                ", pubDate='" + pubDate + '\'' +
                '}';
    }
}
