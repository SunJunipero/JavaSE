package com.streams.examples.FindAndMatch;

import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        Integer first = Stream.of(4, 5, 6, 7, 43, 65, 98)
                .findFirst()
                .get();

        System.out.println("find first -  " + first);

        Integer any = Stream.of(43, 4, 5, 6, 7, 43, 65, 98, 65, 33)
                .findAny()
                .get();

        System.out.println("find any -  " + any);


        /**
         * true хотя бы для одного
         */
        boolean odd = Stream.of(6, 4, 8, 12, 14, 16, 76, 54, 5)
                .anyMatch(integer -> integer % 2 == 0);

        System.out.println("list is odd - " + odd);

        /**
         * для всех
         */
        boolean isOdd = Stream.of(6, 4, 8, 12, 14, 16, 76, 54, 5)
                .allMatch(integer -> integer % 2 == 0);

        System.out.println("list is odd - " + isOdd);

        /**
         * вернет true если false для всех
         */

        boolean isOdd1 = //Stream.of(6, 4, 8, 12, 14, 16, 76, 54, 5)
                Stream.of(7, 9, 5)
                .noneMatch(integer -> integer % 2 == 0);

        System.out.println("list is odd - " + isOdd1);


    }
}
