package com.fi.example.function;

import com.fi.example.TestClass;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * public interface Function<T, R>
 *
 *     - R apply(T var1);
 *     - default <V> Function<V, R> compose(Function<? super V, ? extends T> var1)
 *     - default <V> Function<T, V> andThen(Function<? super R, ? extends V> var1)
 *     - static <T> Function<T, T> identity()
 */
public class FunctionExample {
    public static void main(String[] args) {
        Stream.of(1, 2, 54, 21, 23, 44, 32, 54, 11, 20, 34, 67, 76, 80)
                .map(TestClass::new)
                .map(TestClass::add100)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        Function<Integer, Integer> multBy2 = integer -> integer * 2;
        Function<Integer, Integer> squad = integer -> integer * integer;

        /**
         * Function<T, V> andThen(Function<R,V> var1)
         */
        System.out.println("\t\t  AndThen example");
        System.out.println(multBy2.andThen(squad).apply(5)); //100
        System.out.println(squad.andThen(multBy2).apply(5)); //50
        /**
         * Function<V, R> compose(Function<V,T> var1)
         */
        System.out.println("\t\t  Compose example");
        System.out.println(multBy2.compose(squad).apply(5)); //50
        System.out.println(squad.compose(multBy2).apply(5)); //100

    }
}
