package com.streams.examples.model;

public class Person {
    private String name;
    private Integer age;
    private String city;
    private Department department;

    public Person(){

    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, Integer age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isFromCurrentCity(String currentCity){
        return this.city.equals(currentCity);
    }

    public Person changeName(String newName){
         this.setName(newName + " " +  this.getName());
         return this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city=" + city +
                ", department=" + department +
                '}';
    }
}
