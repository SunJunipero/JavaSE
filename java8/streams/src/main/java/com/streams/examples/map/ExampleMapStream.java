package com.streams.examples.map;

import com.streams.examples.model.Person;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExampleMapStream {
    public static void main(String[] args) {
        List<Person> collect = Stream.of(new Person("Alex", 32, "Spb"),
                new Person("Math", 31),
                new Person("Miles", 33),
                new Person("Jamie", 29 ),
                new Person("Nick", 30 ))
                .map(person -> person.changeName("Lol"))
                .collect(Collectors.toList());

        collect.forEach(System.out::println);


       // Stream.of("a", "v", "df").map(String::toUpperCase).forEach(System.out::println);



    }
}
