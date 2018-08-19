package com.streams.examples.StreamShildt.reduce;

import java.util.ArrayList;

public class MaxLenghtString {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("as");
        list.add("afdsfs");
        list.add("asfsf12");
        list.add("asfsf13");
        list.add("asfs");
        list.add("asfsf");
        list.add("a231s");

        String res = list.stream().reduce("", (s, s2) -> s.length() > s2.length() ? s : s2);
        System.out.println(list.stream().reduce((s, s2) -> s.length() > s2.length() ? s : s2).get());

        System.out.println(res);
    }
}
