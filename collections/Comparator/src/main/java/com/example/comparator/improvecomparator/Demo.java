package com.example.comparator.improvecomparator;

import model.Investor;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Demo {
    public static void main(String[] args) {
        TreeMap<Investor, Double> bank = new TreeMap<>(new MyComparator());

        bank.put(new Investor("Alex", "Turner"), 13453.343);
        bank.put(new Investor("Silent", "Bob"), 5452.4);
        bank.put(new Investor("Vladimir", "Putin"), 3435212.43);
        bank.put(new Investor("Alex", "Bond"), 3442434.43);
        bank.put(new Investor("Redrick", "Shuhart"), 34434.43);

        Set<Map.Entry<Investor, Double>> entries = bank.entrySet();

        for (Map.Entry<Investor, Double> entry : entries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


    }
}
