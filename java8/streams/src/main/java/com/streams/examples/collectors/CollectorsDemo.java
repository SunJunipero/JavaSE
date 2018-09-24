package com.streams.examples.collectors;

import com.streams.examples.collectors.model.Item;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectorsDemo {
    public static void main(String[] args) {
        IntStream intStream = IntStream.range(0, 50);


        Map<String, Integer> collect = intStream.boxed().collect(Collectors.toMap(String::valueOf, Integer::valueOf));

        collect.entrySet().stream().sorted((t, t1) -> t.getValue().compareTo(t1.getValue())).forEach(stringIntegerEntry -> System.out.println(stringIntegerEntry.getKey() + " " + stringIntegerEntry.getValue()));
        System.out.println("\t\t without sorted");
        collect.entrySet().forEach(stringIntegerEntry -> System.out.println(stringIntegerEntry.getKey() + " " + stringIntegerEntry.getValue()));

        /**
         * только если нет дубликатов
         */
        Map<String, Integer> collect2 = Stream.of(1, 2, 5, 6, 8).collect(Collectors.toMap(String::valueOf, Integer::valueOf));

        System.out.println("Collector to map");
        collect2.forEach((s, integer) -> System.out.println(s + "  " + integer));

        /**
         * 3 аргумент в toMap - BinaryOperator<U> var2, Supplier<M> var3 указывает, что делать с дубликатом (var 2 - oldVal, var 3 - newval)
         */

        Map<String, Integer> collect1 = Stream.of(1, 2, 5, 6, 8, 8, 6).collect(Collectors.toMap(String::valueOf, Integer::valueOf, (oldVal, newVal) -> newVal + oldVal));
        System.out.println("Collector to map with dublicate");
        collect1.forEach((s, integer) -> System.out.println(s + "  " + integer));

        /**
         * 4 аргумент в toMap - Supplier<M> var3 указывает, в какую коллекцию поместить )
         */

        System.out.println("Collector to map with supplier");
        TreeMap<String, Integer> collect3 = Stream.of(1, 2, 5, 6, 8, 8, 6, 7, 3, 3).collect(Collectors.toMap(String::valueOf, Integer::valueOf, (oldVal, newVal) -> newVal + oldVal, TreeMap::new));

        collect3.forEach((s, integer) -> System.out.println(s + "  " + integer));

        /**
         * groupingBy
         */
        System.out.println("\t\t groupingBy");
        Map<String, List<String>> collect4 = Stream.of("one", "three", "two", "two", "five", "one")
                .collect(Collectors.groupingBy(Function.identity()));

        System.out.println(collect4);

        Map<String, Long> collect5 = Stream.of("one", "three", "two", "two", "five", "one")
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect5);

        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99")));

        System.out.println("\t\t Collectors.counting");
        Map<String, Long> collect6 = items.stream().collect(Collectors.groupingBy(Item::getName, Collectors.counting()));

        LinkedHashMap<String, Long> collect7 = new LinkedHashMap<>();
        System.out.println(collect6);

        collect6.entrySet()
                .stream()
                .sorted((t, t1) -> t.getValue().compareTo(t1.getValue()))
                .forEachOrdered(entry -> collect7.put(entry.getKey(), entry.getValue()) );
        System.out.println("\t\t Put to linkedMap");
        System.out.println(collect7);

        Map<String, Integer> collect8 = items.stream().collect(Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));

        System.out.println("\t\t Collectors.summingInt");
        System.out.println(collect8);


        Map<BigDecimal, Set<String>> collect9 = items.stream()
                .collect(Collectors.groupingBy(Item::getPrice, Collectors.mapping(Item::getName, Collectors.toSet())));
        System.out.println("\t\tCollectors.mapping");
        System.out.println(collect9);


        System.out.println("\t\t Collectors.summingInt");
        Integer sum = Stream.of(1, 2, 5, 6, 8)
                .collect(Collectors.summingInt(val -> val));

        System.out.println("sum - " + sum);

        /**
         * OR
         */
        System.out.println("\t\t MaptoInt");
        int sum1 = Stream.of(1, 2, 5, 6, 8).mapToInt(integer -> integer).sum();
        System.out.println("sum1 -  " + sum1);

        /**
         * partitioningBy
         */
        Map<Boolean, List<Item>> collect10 = items.stream()
                .collect(Collectors.partitioningBy(item -> item.getQty() > 10));
        System.out.println("\t\t partitioningBy");
        System.out.println(collect10);

        /**
         * IntSummaryStatistics
         */

        IntSummaryStatistics statistics = Stream.of(1, 2, 5, 6, 8, 4, 32, 1)
                .collect(Collectors.summarizingInt(val -> val));

        System.out.println("\t\t Collectors.summarizingInt");
        System.out.println(statistics);

        /**
         * joining
         */
        System.out.println("\t\t joining");
        String join1 = Stream.of("ab", "jf", "po", "dsdf").collect(Collectors.joining());
        System.out.println(join1);
        String join2 = Stream.of("ab", "jf", "po", "dsdf").collect(Collectors.joining("-"));
        System.out.println(join2);
        String join3 = Stream.of("ab", "jf", "po", "dsdf").collect(Collectors.joining("-", "->", "<-"));
        System.out.println(join3);

        /**
         * reducing
         */
        System.out.println("\t\t reducing");
        Integer integer = IntStream.rangeClosed(1, 20)
                .boxed()
                /**
                 * .reduce((integer1, integer2) -> {
                 *                     System.out.println(integer2 - integer1);
                 *                     return integer2 - integer1;
                 *                 })
                 */
                .collect(Collectors.reducing((integer1, integer2) -> {
                    System.out.print(integer2 - integer1 + " ");
                    return integer2 - integer1;
                }))
                .get();

        System.out.println("reduce res - " + integer);

        System.out.println("\t\t reducing with seed");
        Integer collect11 = IntStream.rangeClosed(1, 20)
                .boxed()
                .collect(Collectors.reducing(20, (i, i1) -> {
                    System.out.println(i + i1 + " ");
                    return i + i1;
                }));


        System.out.println("with seed reduce res - " + collect11);




    }
}

