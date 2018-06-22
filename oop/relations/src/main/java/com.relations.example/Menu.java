package com.relations.example;

public class Menu {
    public void showEmployeses(Employee[] employees){
        for (Employee employee: employees) {
            System.out.println(" Name - " + employee.getName() +
                    " positions - " + employee.getPosition()) ;
        }
    }
}
