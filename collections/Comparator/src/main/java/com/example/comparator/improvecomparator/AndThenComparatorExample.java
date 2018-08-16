package com.example.comparator.improvecomparator;

import model.Investor;

import java.util.TreeMap;

public class AndThenComparatorExample {
    public static void main(String[] args) {
        TreeMap<Investor, Double> bank = new TreeMap<>(new LastNameComparator().thenComparing(new FirstNameComaprator()));

        bank.put(new Investor("Alex", "Turner"), 13453.343);
        bank.put(new Investor("Silent", "Bob"), 5452.4);
        bank.put(new Investor("Vladimir", "Putin"), 3435212.43);
        bank.put(new Investor("Alex", "Bond"), 3442434.43);
        bank.put(new Investor("Redrick", "Shuhart"), 34434.43);

        bank.entrySet().stream()
                .forEach(investorDoubleEntry -> System.out.println(investorDoubleEntry.getKey() + " "+ investorDoubleEntry.getValue()));


    }
}
