package com.streams.examples.limit;

import java.util.stream.Stream;

/**
 *  Stream.of(6, 5,43, 6, 7, 7, 12, 54, 32)
 *                 .limit(4)
 *   -> 6 5 43 6
 *
 *   Пропустить только первые n элементов
 *
 */
public class Demo {
    public static void main(String[] args) {
        Stream.of(6, 5,43, 6, 7, 7, 12, 54, 32)
                .limit(4)
                .forEach(integer -> System.out.print(integer + " "));
    }
}
