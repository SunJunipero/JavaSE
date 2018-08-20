package com.streams.examples.collect;

import com.streams.examples.model.Person;

import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExampleCollectStream {
    public static void main(String[] args) {
        List<Person> collect = Stream.of(new Person("Alex", 32, "Spb"),
                new Person("Math", 31, "Mgn"),
                new Person("Miles", 33, "Spb"),
                new Person("Jamie", 29, "Spb"),
                new Person("Nick", 30, "Pzt"))
                .collect(Collectors.toList());

        collect.forEach(System.out::println);


        /**
         * toCollection
         */

        /**
         * needed implement comparable
         */

        System.out.println("\t\t Collectors.toCollection");
        TreeSet<Person> collect1 = Stream.of(new Person("Alex", 32, "Spb"),
                new Person("Math", 31, "Mgn"),
                new Person("Jamie", 29, "Spb"),
                new Person("Nick", 30, "Pzt"),
                new Person("Miles", 33, "Spb"))
                .collect(Collectors.toCollection(TreeSet::new));

        collect1.forEach(System.out::println);


    }
}
