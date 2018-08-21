package com.fi.example.BiFunction;

import com.fi.example.BiFunction.model.Book;

import java.util.function.BiFunction;

/**
 * public interface BiFunction<T, U, R>
 *     R apply(T var1, U var2);
 *     default <V> BiFunction<T, U, V> andThen(Function<? super R, ? extends V> var1)
 */
public class BifunctionExample {
    public static void main(String[] args) {
        BiFunction<Integer, String, Book> init = ((price, name) -> new Book(price, name));

        Book hamlet = init.apply(722, "Hamlet");
        Book RandJ = init.apply(123, "Romeo and Juliet");

    }
}
