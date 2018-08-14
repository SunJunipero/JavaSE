package com.fi.example.Suplier;

import com.fi.example.TestClass;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Supplier<T>
 *     -T get();
 */
public class SuplierExample {

    static <T> T fromSupplier (Supplier<T> supplier){
        return supplier.get();
    }
    public static void main(String[] args) {
        Supplier<List<TestClass>> supplier = () -> Stream.of(12, 34, 54)
                .map(TestClass::new)
                .collect(Collectors.toList());

        List<TestClass> testClasses = fromSupplier(supplier);

        testClasses.forEach(System.out::println);


    }
}
