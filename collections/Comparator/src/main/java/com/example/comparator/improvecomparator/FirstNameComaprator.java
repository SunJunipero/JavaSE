package com.example.comparator.improvecomparator;

import model.Investor;

import java.util.Comparator;

public class FirstNameComaprator implements Comparator<Investor> {

    @Override
    public int compare(Investor investor, Investor t1) {
        return investor.getName().compareTo(t1.getName());
    }
}
