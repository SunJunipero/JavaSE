package com.example.comparator.reversecomparator;

import java.util.TreeSet;

public class MyComparatorDemo {


    public static void main(String[] args) {
        TreeSet<String> backTreeSet = new TreeSet<>(new MyComp());
        backTreeSet.add("G");
        backTreeSet.add("O");
        backTreeSet.add("A");
        backTreeSet.add("P");
        backTreeSet.add("V");
        backTreeSet.add("K");
        backTreeSet.add("L");
        System.out.println("\t\tReverse comparator");
        backTreeSet.forEach(s -> System.out.print(s + " "));


        TreeSet<String> directTreeSet = new TreeSet<>();
        directTreeSet.add("G");
        directTreeSet.add("O");
        directTreeSet.add("A");
        directTreeSet.add("P");
        directTreeSet.add("V");
        directTreeSet.add("K");
        directTreeSet.add("L");

        System.out.println("\n\t\tDirect comparator");
        directTreeSet.forEach(s -> System.out.print(s + " "));

        TreeSet<String> backLamdaTreeSet = new TreeSet<>(((s, t1) -> t1.compareTo(s)));
        backLamdaTreeSet.add("G");
        backLamdaTreeSet.add("O");
        backLamdaTreeSet.add("A");
        backLamdaTreeSet.add("P");
        backLamdaTreeSet.add("V");
        backLamdaTreeSet.add("K");
        backLamdaTreeSet.add("L");
        System.out.println("\n\t\tBack lambda comparator");
        backLamdaTreeSet.forEach(s -> System.out.print(s + " "));


        TreeSet<String> reversedComaprator = new TreeSet<>(new MuDirectComparator().reversed());
        reversedComaprator.add("G");
        reversedComaprator.add("O");
        reversedComaprator.add("A");
        reversedComaprator.add("P");
        reversedComaprator.add("V");
        reversedComaprator.add("K");
        reversedComaprator.add("L");
        System.out.println("\n\t\tReversed comparator");
        reversedComaprator.forEach(s -> System.out.print(s + " "));



    }
}
