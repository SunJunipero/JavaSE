package com.streams.examples.peek;

import java.util.stream.Stream;

/**
 * Применить consumer к каждому элементу стрима
 */
public class Demo {
    public static void main(String[] args) {
        long count = Stream.of(4, 5, 67, 43, 21, 7, 8, 33)
                .peek(integer -> System.out.print(integer + " "))
                .count();
    }
}
