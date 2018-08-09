package com.enumexample.demoEnum;
import com.enumexample.demoEnum.model.*;


public class Demo {
    public static void main(String[] args) {
        for (Genre genre : Genre.values()) {
            System.out.println(genre.getName());
        }
    }
}
