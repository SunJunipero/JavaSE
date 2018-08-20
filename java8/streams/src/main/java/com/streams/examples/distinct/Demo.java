package com.streams.examples.distinct;

import java.util.stream.Stream;

/**
 * distinct вернет стрим без дубликатов
 * Stream.of(4, 5, 5, 45, 32, 32, 7, 8, 43, 23, 27)
 * 4 5 45 32 7 8 43 23 27
 */
public class Demo {
    public static void main(String[] args) {
        Stream.of(4, 5, 5, 45, 32, 32, 7, 8, 43, 23, 27)
                .distinct()
                .forEach(integer -> System.out.print(integer + " "));
    }
}
