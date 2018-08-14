package com.fi.example.UnariOperator;

import com.fi.example.TestClass;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UnariOperatorExample {


    public static void main(String[] args) {
        UnaryOperator <Integer> operator = new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return null;
            }
        };

        List<TestClass> collect = Stream.of(1, 2, 54, 21, 23, 44, 32, 54, 11, 20, 34, 67, 76, 80)
                .map(TestClass::new)
                .collect(Collectors.toList());

        collect.replaceAll(TestClass::changeVal);

        collect.forEach(System.out::println);


    }
}
