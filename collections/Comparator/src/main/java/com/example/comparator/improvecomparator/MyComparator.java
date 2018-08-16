package com.example.comparator.improvecomparator;

import model.Investor;

import java.util.Comparator;

public class MyComparator implements Comparator<Investor> {
    @Override
    public int compare(Investor investor, Investor t1) {
        int k = investor.getLastname().compareTo(t1.getName());
        return k == 0 ? investor.getName().compareTo(t1.getName()) : k;
    }
}
