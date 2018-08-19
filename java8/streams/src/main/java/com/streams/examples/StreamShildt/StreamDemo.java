package com.streams.examples.StreamShildt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * min
 * max
 * forEach
 * filter
 * sorted
 */
public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> list = Stream.of(1, 5, 78, 65, 23, 9, 11, -87, 43, 42, 53, 89, 1, -56)
                .map(Integer::new)
                .collect(Collectors.toList());

        System.out.println("\t\t Min");
        int minIndex = 0;
        Optional<Integer> min = list.stream().min(Integer::compareTo);
        if (min.isPresent()) {
            System.out.println(min.get());
        }

        System.out.println("\t\t Max");
        Optional<Integer> max = list.stream().max(Integer::compareTo);
        if (max.isPresent()) {
            System.out.println(max.get());
        }

        System.out.println("\t\t Sorted");
        Stream<Integer> sorted = list.stream().sorted();
        sorted.forEach(integer -> System.out.print(integer + " "));

        System.out.println("\n\t\t Filter");
        Stream<Integer> integerStream = list.stream().filter(integer -> integer % 2 == 0);
        integerStream.forEach(integer -> System.out.print(integer + " "));

    }
}
