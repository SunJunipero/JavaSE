package com.streams.examples.flatMap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapArrayExample {
    public static void main(String[] args) {
        String [][] data = {{"map", "flatmap"}, {"collect","reduce","min"}, {"max", "filter"}};

        Stream<String[]> stream = Arrays.stream(data);

        Stream<String> stringStream = stream.flatMap(Arrays::stream);

        stringStream.forEach(System.out::println);
    }

}
