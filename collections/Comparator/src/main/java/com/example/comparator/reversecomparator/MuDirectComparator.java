package com.example.comparator.reversecomparator;

import java.util.Comparator;

public class MuDirectComparator implements Comparator<String> {
    @Override
    public int compare(String s, String t1) {
        return s.compareTo(t1);
    }
}
