package com.fi.example.BiConsumer;

import com.fi.example.BiConsumer.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * public interface BiConsumer<T, U>
 *
 *     void accept(T var1, U var2);
 *     default BiConsumer<T, U> andThen(BiConsumer<? super T, ? super U> var1)
 */
public class BiConsumerExample {
    public static void main(String[] args) {
        BiConsumer<String, Book> addName = ((s, book) -> book.setName(s));

        Book book = new Book("Java 8");

        System.out.println(book);

        addName.accept("Java 9", book);

        System.out.println(book);




    }


}
