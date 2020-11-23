package com.relations.example;

import java.util.Random;
import java.util.stream.Stream;

public class Draft {
    public static void main(String[] args) {
        System.out.println("Hello, its draft folder !!!");

        Stream.generate(() -> new Random().nextInt(100))
                .limit(10)
                .map(i -> i + 100)
                .forEach(System.out::println);

        System.out.println("OLOLOL");

        int b = 1000;
    }
}