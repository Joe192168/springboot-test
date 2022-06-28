package com.joe.annotation2;

@MyDocumentedtAnnotation2(str = "wwj", strArr = {"str1", "str2"})
public class DocumentedAnnotationTest2 {

    private String name;

    public DocumentedAnnotationTest2() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DocumentedAnnotationTest{" +
                "name='" + name + '\'' +
                '}';
    }
}
