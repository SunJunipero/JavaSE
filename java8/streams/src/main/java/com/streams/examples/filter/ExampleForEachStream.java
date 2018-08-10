package com.streams.examples.filter;

import com.streams.examples.model.Person;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ExampleForEachStream {
    public static void main(String[] args) {
        List<Person> personList = new LinkedList<>();
        personList.add(new Person("Alex", 23, "SPb"));
        personList.add(new Person("Miles", 32, "SPb"));
        personList.add(new Person("Nick", 31, "Ptz"));
        personList.add(new Person("Matt", 28, "Ptz"));
        personList.add(new Person("Jamie", 30, "Mgn"));

        System.out.println(oldFor(personList));
        System.out.println(iteratorFor(personList));
        System.out.println(straemForEach(personList));
        //straemForEach(personList);
    }

    static int oldFor(List<Person> personList){
        int count = 0;
        for (Person person : personList) {
            if (person.isFromCurrentCity("SPb")) {
                count++;
            }
        }
        return count;
    }

    static int iteratorFor(List<Person> personList){
        int count = 0;
        Iterator<Person> iterator = personList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().isFromCurrentCity("SPb")) {
                count++;
            }
        }
        return count;
    }

    static long straemForEach(List<Person> personList){
          return  personList.stream()
               .filter(person -> person.isFromCurrentCity("SPb"))
                 .count();
    }
}
