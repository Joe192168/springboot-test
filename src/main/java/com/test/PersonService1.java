package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonService1 {

    //假设这个list是通过已有接口返回的所有Person集合
    private List<Person> list = new ArrayList<Person>();

    public PersonService1(){
        Person person = new Person();
        person.setName("张三");
        person.setAge(12);
        person.setGender("男");

        list.add(person);
    }

    //第一个方法，通过姓名找到符合Person对象
    public List<Person> findByName(String name){
        return find(p-> name.equals(p.getName()));
    }
    //根据性别找出符合的Person对象
    public List<Person> findByGender(String gender){
        return find(p-> gender.equals(p.getGender()));
    }

    /*//如果你觉得find方法也臃肿，也可以改造
    public List<Person> find(Predicate<Person> predicate){
        List<Person> people = new ArrayList<>();
        for (Person p : list){
            if(predicate.test(p)){
                people.add(p);
            }
        }
        return people;
    }*/

    //lambda表达式改造后
    public List<Person> find(Predicate<Person> predicate){
        return list.stream().filter(p->predicate.test(p)).collect(Collectors.toList());
    }

/*    interface Criteria{
        boolean matches(Person person);
    }*/

}
