package com.fi.example.consumer;

import com.fi.example.TestClass;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**  Consumer
 *      -void accept(T var1);
 *      -default Consumer<T> andThen(Consumer<? super T> var1) {
 *
 */
public class ConsumerExample {


    public static void main(String[] args) {

        Consumer<TestClass> multby10 = new Consumer<TestClass>() {
            @Override
            public void accept(TestClass testClass) {
                testClass.setVal(testClass.getVal() * 10);
            }
        };

        List<TestClass> collect = Stream.of(1, 2, 54, 21, 23, 44, 32, 54, 11, 20, 34, 67, 76, 80)
                .map(TestClass::new)
                .collect(Collectors.toList());



        collect.forEach(TestClass::forConsumer);
        //collect.forEach(multby10);
        collect.forEach(System.out::println);

        /**
         * TestClass{val=10}
         * TestClass{val=20}
         * TestClass{val=540}
         * TestClass{val=210}
         * TestClass{val=230}
         * TestClass{val=440}
         * TestClass{val=320}
         * TestClass{val=540}
         * TestClass{val=110}
         * TestClass{val=200}
         * TestClass{val=340}
         * TestClass{val=670}
         * TestClass{val=760}
         * TestClass{val=800}
         */
        Consumer<TestClass> div10 = testClass -> testClass.setVal(testClass.getVal() /10);
        Consumer<TestClass> addfive = testClass -> testClass.setVal(testClass.getVal() + 5);

        collect.forEach(div10.andThen(addfive));
        collect.forEach(System.out::println);
        /**
         * TestClass{val=6}
         * TestClass{val=7}
         * TestClass{val=59}
         * TestClass{val=26}
         * TestClass{val=28}
         * TestClass{val=49}
         * TestClass{val=37}
         * TestClass{val=59}
         * TestClass{val=16}
         * TestClass{val=25}
         * TestClass{val=39}
         * TestClass{val=72}
         * TestClass{val=81}
         * TestClass{val=85}
         */




    }
}
