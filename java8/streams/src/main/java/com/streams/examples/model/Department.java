package com.streams.examples.model;

import java.util.HashSet;
import java.util.Set;

public class Department {
    private String nameDepartment;
    private Set<Person> people = new HashSet<>();

    public Department(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }

    public void addPeople(Person person){
        people.add(person);
        person.setDepartment(this);
    }

    @Override
    public String toString() {
        return "Department{" +
                "nameDepartment='" + nameDepartment + '\'' +
                '}';
    }
}
