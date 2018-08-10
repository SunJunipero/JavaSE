package com.streams.examples.flatMap;

import com.streams.examples.model.Person;

import java.util.Arrays;
import java.util.stream.Stream;

public class ExampleFaltMapStream {
    public static void main(String[] args) {
        Stream.of(Arrays.asList(new Person("Alex", 32, "Spb"), new Person("Math", 31, "Mgn")),
                Arrays.asList(new Person("Miles", 33, "Spb"), new Person("Jamie", 29, "Spb")))
                .flatMap(personList -> personList.stream())
                .forEach(System.out::println);
    }
}


