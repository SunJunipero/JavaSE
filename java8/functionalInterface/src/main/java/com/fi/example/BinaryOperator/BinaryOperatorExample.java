package com.fi.example.BinaryOperator;

import com.fi.example.BinaryOperator.model.Book;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * public interface BinaryOperator<T> extends BiFunction<T, T, T> {
 *
 *     static <T> BinaryOperator<T> minBy(Comparator<? super T> var0)
 *
 *     static <T> BinaryOperator<T> maxBy(Comparator<? super T> var0)
 *
 */
public class BinaryOperatorExample {
    public static void main(String[] args) {
        BinaryOperator<String> operator = (s, s2) -> new StringBuilder(s).append(" ").append(s2).toString();

        String apply = operator.apply("Arctic", "Monkeys");

        System.out.println(apply);

        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Hamlet", 34.5, "Poem"));
        books.add(new Book("Lost Paradise", 69.5, "Poem"));
        books.add(new Book("Demon", 19.5, "Poem"));
        books.add(new Book("Theory of everything", 23.5, "CF"));
        books.add(new Book("The selfish gen", 48.5, "CF"));
        books.add(new Book("You're Joking, Mr. Feynman!", 58.5, "CF"));

        Comparator<Book> comparePrice = Comparator.comparing(Book::getPrice);

        /**
         * maxBy example (minBy will be same)
         */
        Map<String, Optional<Book>> collect = books.stream()
                .collect(Collectors.groupingBy(Book::getGenre,
                        Collectors.reducing(BinaryOperator.maxBy(comparePrice))));

        collect.forEach((key, value) -> System.out.println(key + " --- " + value.get()));





    }

}
