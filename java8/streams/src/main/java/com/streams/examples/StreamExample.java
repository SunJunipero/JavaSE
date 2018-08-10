package com.streams.examples;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * stream - средство конструирования операций над коллекциями с применением
 * функционального подхода.
 */

public class StreamExample {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();

        strings.add("one");
        strings.add("two");
        strings.add("three");
        strings.add("four");

        Stream<String> stringStream = strings.stream();
        stringStream.forEach(x  -> System.out.println(x));
        /**
         * Стрим можно использовать только один раз!
         * иначе - Exception in thread "main" java.lang.IllegalStateException:
         * stream has already been operated upon or closed
         */
        //stringStream.forEach(x  -> System.out.println(x));
    }
}
