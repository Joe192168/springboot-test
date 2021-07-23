package com.test;

import java.util.ArrayList;
import java.util.List;

public class PersonService {

    //假设这个list是通过已有接口返回的所有Person集合
    private List<Person> list = new ArrayList<Person>();

    public PersonService(){
        Person person = new Person();
        person.setName("张三");
        person.setAge(12);
        person.setGender("男");

        list.add(person);
    }

    //第一个方法，通过姓名找到符合Person对象
    public List<Person> findByName(String name){
        return find(new Criteria() {
            @Override
            public boolean matches(Person person) {
                return name.equals(person.getName());
            }
        });
    }
    //根据性别找出符合的Person对象
    public List<Person> findByGender(String gender){
        return find(new Criteria() {
            @Override
            public boolean matches(Person person) {
                return gender.equals(person.getGender());
            }
        });
    }

    public List<Person> find(Criteria criteria){
        List<Person> people = new ArrayList<>();
        for (Person p : list){
            if(criteria.matches(p)){
                people.add(p);
            }
        }
        return people;
    }

    interface Criteria{
        boolean matches(Person person);

    }
}