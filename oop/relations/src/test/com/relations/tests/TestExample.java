package com.relations.tests;

import com.relations.example.Department;
import com.relations.example.Employee;
import com.relations.example.PastPosition;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

import static org.junit.Assert.*;

public class TestExample {

    Employee alex = new Employee("Alex", "Turner", "developer");
    Employee math = new Employee("Math", "Halders", "developer");
    Employee cook = new Employee("Jamie", "Cook", "developer");
    Employee nick = new Employee("Nick", "Omaley", "developer");

    @Test
    public void simpleTest(){


        Department arctic_monkyes = new Department("Arctic Monkyes");
        arctic_monkyes.addEmployee(alex);
        arctic_monkyes.addEmployee(math);
        arctic_monkyes.addEmployee(cook);

        assertEquals(Integer.valueOf(3), arctic_monkyes.getPersonCount());

    }

    @Test
    public void pastPositionTest(){

        Department old_monkyes = new Department("old monkyes");
        old_monkyes.addEmployee(alex);
        PastPosition qa = new PastPosition("QA", old_monkyes);

        Department lab = new Department("lab");
        lab.addEmployee(alex);
        PastPosition jun_lab = new PastPosition("jun lab", lab);


        alex.addPastPosition(qa);
        alex.addPastPosition(jun_lab);

        //System.out.println(alex.getPastPositions());
        HashSet<String> old_positions = new HashSet<>();
        Iterator<PastPosition> iterator = alex.getPastPositions().iterator();
        while (iterator.hasNext()) {
            old_positions.add(iterator.next().getName());
        }
        System.out.println(old_positions);

        assertEquals(new HashSet<>(Arrays.asList("QA", "jun lab")), old_positions);

    }

    @Test
    public void departmentTest(){
        Department arctic_monkyes = new Department("Arctic Monkyes");
        arctic_monkyes.addEmployee(alex);
        arctic_monkyes.addEmployee(math);
        arctic_monkyes.addEmployee(cook);
        arctic_monkyes.addEmployee(nick);

        assertEquals(arctic_monkyes.getName(), nick.getDepartment().getName());

    }
}
