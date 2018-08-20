package com.streams.examples.skip;

import java.util.stream.Stream;

/**
 * Пропустить первые n елементов
 * Stream.of(4, 5, 6, 12, 6, 2, 87, 34).skip(5)
 *  -> 2 87 34
 *  Stream.of(4, 5, 6, 12, 6, 2, 87, 34).skip(4)
 *  * -> 6 2 87 34
 */
public class Demo {
    public static void main(String[] args) {
        Stream.of(4, 5, 6, 12, 6, 2, 87, 34)
                .skip(5)
                .forEach(System.out::println);
    }
}
