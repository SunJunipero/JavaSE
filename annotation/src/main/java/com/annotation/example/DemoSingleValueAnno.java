package com.annotation.example;

import com.annotation.example.anno.SingleAnno;

@SingleAnno(1211)
public class DemoSingleValueAnno {
    public static void main(String[] args) {
        System.out.println(DemoSingleValueAnno.class.getAnnotation(SingleAnno.class).value());
    }
}
