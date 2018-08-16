package com.example.comparator.improvecomparator;

import model.Investor;

import java.util.Comparator;

public class LastNameComparator implements Comparator<Investor> {
    @Override
    public int compare(Investor investor, Investor t1) {
        return investor.getLastname().compareTo(t1.getName());
    }
}
