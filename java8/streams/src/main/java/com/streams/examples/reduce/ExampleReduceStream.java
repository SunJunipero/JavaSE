package com.streams.examples.reduce;

import com.streams.examples.model.Person;

import java.util.stream.Stream;

/**
 * min
 * max
 * count
 */

public class ExampleReduceStream {
    public static void main(String[] args) {
        System.out.println(Stream.of(new Person("Alex", 32, "Spb"),
                new Person("Math", 31, "Mgn"),
                new Person("Miles", 33, "Spb"),
                new Person("Jamie", 29, "Spb"),
                new Person("Nick", 30, "Pzt"))
                .map(Person::getAge)
                .reduce((integer, integer2) -> integer + integer2)
                .get());


    }
}
