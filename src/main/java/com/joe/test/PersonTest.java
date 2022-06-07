package com.joe.test;

import java.util.List;

public class PersonTest {

    public static void main(String[] args) {
        PersonService1 personService = new PersonService1();
        List<Person> personList = personService.findByName("张三");
        for (Person person : personList) {
            System.out.println(person);
        }
    }
}
