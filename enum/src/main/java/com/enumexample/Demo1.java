package com.enumexample;

import java.util.Arrays;

enum Genre{
    Ambient, IDM, HipHop, Rock, NewAge
}

public class Demo1 {
    public static void main(String[] args) {
        Genre newGenre = Genre.Ambient;

        System.out.println("newGenre - " + newGenre);

        if (newGenre == Genre.Ambient)
            System.out.println("new genre is - " + newGenre);

        switch (newGenre){
            case IDM:
                System.out.println("this is " + Genre.IDM);
                break;
            case Rock:
                System.out.println("this is " + Genre.Rock);
                break;
            case Ambient:
                System.out.println("this is " + Genre.Ambient);
                break;
        }

        System.out.println(Arrays.toString(Genre.values()));

        Genre rock = Genre.valueOf("NewAge");
        System.out.println(rock);

    }
}
