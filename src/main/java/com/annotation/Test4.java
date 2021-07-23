package com.annotation;

//得到Class的几种方式
public class Test4 {

    public static void main(String[] args) throws Exception{
        //方式一：对象获取
        Person person = new Student();
        System.out.println("我是："+person.getName());

        Class c1 = person.getClass();
        System.out.println(c1.hashCode());

        //方式二：forName获取
        Class c2 = Class.forName("com.annotation.Student");
        System.out.println(c2.hashCode());

        //方式三：类名.class获取
        Class<Student> c3 = Student.class;
        System.out.println(c3.hashCode());

        //方式四：基本内置类型的包装类都有一个TYPE属性
        Class<Integer> type = Integer.TYPE;
        System.out.println(type);


    }

}


class Person{

    private String name;

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

class Student extends Person {
    public Student() {
        this.setName("学生");
    }
}

class Teacher extends Person {
    public Teacher() {
        this.setName("老师");
    }
}