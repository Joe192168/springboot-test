package com.joe.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class Test5 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        //通过反射包名获取class对象
        Class c1 = Class.forName("com.joe.reflection.Users");

        //获取注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("获得注解："+annotation);
        }

        //获取注解value的值
        TableDB table = (TableDB)c1.getAnnotation(TableDB.class);
        String value = table.value();
        System.out.println("获取注解的value："+value);

        //获得类的指定字段的注解
        Field field = c1.getDeclaredField("name");
        FieldDB annotation = field.getAnnotation(FieldDB.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());
    }

}

//实体类
@TableDB("Users")
class Users{
    @FieldDB(columnName = "id",type = "int",length = 12)
    private int id;
    @FieldDB(columnName = "age",type = "int",length = 5)
    private int age;
    @FieldDB(columnName = "name",type = "varchar",length = 20)
    private String name;

    public Users() {
    }

    public Users(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

//表注解
//作用类上
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableDB{
    String value();
}

//字段注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldDB{
    //列名称
    String columnName();
    //类型
    String type();
    //字段长度
    int length();
}
