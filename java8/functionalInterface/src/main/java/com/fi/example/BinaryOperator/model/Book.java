package com.fi.example.BinaryOperator.model;

public class Book {
    private String name;
    private double price;
    private String genre;

    public Book(String name, double price, String genre) {
        this.name = name;
        this.price = price;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String toString(){
        return name + " " + price + " " + genre;
    }
}
