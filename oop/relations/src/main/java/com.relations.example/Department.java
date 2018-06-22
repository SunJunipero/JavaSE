package com.relations.example;

import java.util.HashSet;
import java.util.Set;

public class Department implements Units{
    private String name;
    private Set<Employee> employees = new HashSet<>();

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addEmployee(Employee newEmployee){
        employees.add(newEmployee);
        newEmployee.setDepartment(this);

    }

    public void deleteEmployee(Employee currentEmployee){
        employees.remove(currentEmployee);
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    @Override
    public Integer getPersonCount() {
        return employees.size();
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}
