package com.joe.annotation2;

@MyDocumentedtAnnotation
public class DocumentedAnnotationTest {

    private String name;

    public DocumentedAnnotationTest() {
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
