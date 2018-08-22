package com.streams.examples.initial;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
//        Stream.iterate(12, integer -> integer + 10)
//                .forEach(System.out::println); // infinity stream

       // Stream.generate(()->12).forEach(System.out::println);  // infinity stream

        /**
         * 0 1 2 3 4 5 6 7 8 9
         */
        IntStream.range(0, 10).forEach(i ->System.out.print(i + " "));
        System.out.println();
        /**
         * 0 1 2 3 4 5 6 7 8 9 10
         */
        IntStream.rangeClosed(0, 10).forEach(i ->System.out.print(i + " "));




    }
}
