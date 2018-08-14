package com.fi.example.predicate;

import com.fi.example.TestClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Predicate<T>
 *
 * - boolean test(T var1);
 * - default Predicate<T> and(Predicate<? super T> var1)
 * - default Predicate<T> negate()
 * - default Predicate<T> or(Predicate<? super T> var1)
 * - static <T> Predicate<T> isEqual(Object var0)
 *
 */
public class PredicateExample {


    public static void main(String[] args) {
        ArrayList<TestClass> testClasses = new ArrayList<>();

        TestClass limit = new TestClass(50);

        /**
         * test method usage
         */
        System.out.println("\t\t test");
        long count = Stream.of(1, 2, 54, 21, 23, 44, 32, 54, 11, 20, 34, 67, 76, 80).map(TestClass::new)
                 /**
                 * testClass -> testClass.getVal() < 50
                 */
                //.filter(limit::lessThan)
                .filter(TestClass::lessThan)
                .count();
        System.out.println("count = " + count);

        /**
         * negate
         */
        System.out.println("\t\t nagate");
        Predicate<TestClass> predicate = testClass -> testClass.getVal() < 50;

        count = Stream.of(1, 2, 54, 21, 23, 44, 32, 54, 11, 20, 34, 67, 76, 80).map(TestClass::new)
                .filter(predicate.negate())
                .map(testClass -> {
                    System.out.println(testClass.getVal());
                    return testClass.getVal();
                })
                .count();
        System.out.println("count = " + count);

        /**
         * and
         */

        System.out.println("\t\t And");
        Predicate<TestClass> predicate1 = testClass -> testClass.getVal() % 2 == 0;

        count = Stream.of(1, 2, 54, 21, 23, 44, 32, 54, 11, 20, 34, 67, 76, 80).map(TestClass::new)
                .filter(predicate.and(predicate1))
                .map(testClass -> {
                    System.out.println(testClass.getVal());
                    return testClass.getVal();
                })
                .count();
        System.out.println("count = " + count);

        /**
         * and
         */

        System.out.println("\t\t or");
        Predicate<TestClass> predicate2 = testClass -> testClass.getVal() % 10 == 0;

        count = Stream.of(1, 2, 54, 21, 23, 44, 32, 54, 11, 20, 34, 67, 76, 80).map(TestClass::new)
                .filter(predicate.or(predicate2))
                .map(testClass -> {
                    System.out.println(testClass.getVal());
                    return testClass.getVal();
                })
                .count();
        System.out.println("count = " + count);







    }
}
