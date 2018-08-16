package com.example.comparator.reversecomparator;

import java.util.Comparator;

public class MyComp implements Comparator<String> {
    @Override
    public int compare(String s, String t1) {
        return t1.compareTo(s);
    }
}
