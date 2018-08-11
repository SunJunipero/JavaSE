package com.streams.examples.MaxMin;

import com.streams.examples.model.Person;

import java.util.Comparator;
import java.util.stream.Stream;

public class ExampleMaxMinStream {
    public static void main(String[] args) {
        Person person = Stream.of(new Person("Alex", 32, "Spb"),
                new Person("Math", 31, "Mgn"),
                new Person("Miles", 33, "Spb"),
                new Person("Jamie", 29, "Spb"),
                new Person("Nick", 30, "Pzt"))
                .max(Comparator.comparing(Person::getAge))
                .get();

       // System.out.println(person);
        // stringComaring();
        integerComparing();
    }

    static void stringComaring() {
        String s1 = "string1";
        String s2 = new String("string1");


        if (s2.intern() == s1) {
            System.out.println("string is equals");
        }
        else {
            System.out.println("string is not equals");
        }

    }

    static void integerComparing(){
        /**
         * Integers values are equal from -127 to 127
         */
        Integer num1 = -127;
        Integer num2 = -127;

        if (num1 == num2) {
            System.out.println("integer is equals");
        }
        else
            System.out.println("integer is not equals");
    }
}