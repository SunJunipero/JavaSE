package com.streams.examples.model;

import java.util.LinkedList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Person> personList = new LinkedList<>();
        personList.add(new Person("Alex", 23));
        personList.add(new Person("Miles", 32));
        personList.add(new Person("Nick", 31));
        personList.add(new Person("Matt", 28));



        Department programmers = new Department("Programmers");
        programmers.addPeople(personList.get(0));
        programmers.addPeople(personList.get(3));

        Department qa = new Department("QA");
        qa.addPeople(personList.get(1));
        qa.addPeople(personList.get(2));

        programmers.getPeople().forEach(person -> System.out.println(person));
        qa.getPeople().forEach(System.out::println);

    }
}
