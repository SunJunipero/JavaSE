package com.streams.examples.initial;

import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        Stream.iterate(12, integer -> integer + 10)
                .forEach(System.out::println); // infinity stream

        Stream.generate(()->12).forEach(System.out::println);  // infinity stream
    }
}
