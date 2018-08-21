package com.streams.examples.flatMap;

import com.streams.examples.flatMap.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapObjectExample {
    public static void main(String[] args) {
        Person alex = new Person("Alex");
        alex.addBook("12 rules");
        alex.addBook("Handshake with devil");
        alex.addBook("Piece and War");

        Person miles = new Person("Miles");
        miles.addBook("12 rules");
        miles.addBook("Piece and War");
        miles.addBook("Effective Java");

        ArrayList<Person> people = new ArrayList<>();
        people.add(alex);
        people.add(miles);

         //List<String> res = people.stream()
         Set<String> res = people.stream()
                //Stream<Set<String>>
                .map(Person::getBooks)
                //Stream<String>
                .flatMap(strings -> strings.stream())
                //.distinct()
                //.collect(Collectors.toList());
                .collect(Collectors.toSet());

         res.forEach(System.out::println);




    }
}
