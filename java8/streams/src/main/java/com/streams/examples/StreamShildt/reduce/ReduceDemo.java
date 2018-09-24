package com.streams.examples.StreamShildt.reduce;

import java.util.Optional;
import java.util.stream.Stream;

/**
 *     T reduce(T var1, BinaryOperator<T> var2);
 *
 *     Optional<T> reduce(BinaryOperator<T> var1);
 *
 *     <U> U reduce(U var1, BiFunction<U, ? super T, U> var2, BinaryOperator<U> var3);
 *
 *     Операция накопления должна удовлетворять трем ограничениям:
 *
 *      1) Без сохранения состояния
 *             т.е опирается на сведения о состоянии -> каждый элемент обрабатывается отдельно
 *      2) Без вмешательства
 *              источник данных не изменяется
 *      3) Ассоциативная
 *              если ассициативный оператор применяется последовательно к операндам, то не имеет знаячения какая пара из
 *              операндов обрабатывается первой.
 */

public class ReduceDemo {
    public static void main(String[] args) {
        Optional<Integer> reduce = Stream.of(5, 6, 4)
                .map(Integer::new)
                .reduce((integer, integer2) -> integer * integer2);
        System.out.println("\t\t Reduce through Optional");
        System.out.println(reduce.get());

        int i = Stream.of(5 ,6 ,4)
                .map(Integer::new)
                .reduce(10, (integer, integer2) -> integer * integer2);

        System.out.println("\t\t Reduce through type");
        System.out.println(i);




    }
}
