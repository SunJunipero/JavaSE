package com.streams.examples.flatMap.model;

import java.util.HashSet;
import java.util.Set;

public class Person {
    private String name;
    private Set<String> books;

    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addBook(String book){
        if (books == null)
            books = new HashSet<>();
        books.add(book);
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getBooks() {
        return books;
    }

    public void setBooks(Set<String> books) {
        this.books = books;
    }
}
