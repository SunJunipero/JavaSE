package com.streams.examples.StreamShildt.reduceAndParallel;

import java.util.ArrayList;
import java.util.function.BiFunction;

/**
 *     T reduce(T var1, BinaryOperator<T> var2);
 *             var1 - значение идентиности
 *
 *     Optional<T> reduce(BinaryOperator<T> var1);
 *
 *     <U> U reduce(U var1, BiFunction<U, ? super T, U> var2, BinaryOperator<U> var3);
 *              var1 - значение идентичности
 *              var2 - накопитель (accum)
 *              var3 - объединитель (comb) (ф-я объединяющая два значения, получаемые ф-ей, определяемой параметром
 *              накопитель)
 *
 *     public interface BiFunction<T, U, R> {
 *          R apply(T var1, U var2);
 *     }
 *
 *     public interface BinaryOperator<T> extends BiFunction<T, T, T>
 *
 *     Операция накопления должна удовлетворять трем ограничениям:
 *
 *      1) Без сохранения состояния
 *             т.е опирается на сведения о состоянии -> каждый элемент обраьатывается отдельно
 *      2) Без вмешательства
 *              источник данных не изменяется
 *      3) Ассоциативная
 *              если ассициативный оператор применяется последовательно к операндам, то не имеет знаячения какая пара из
 *              операндов обрабатывается первой. ((10 * 2) * 5) = (10 * (2 * 5))
 */

public class Demo {
    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<>();

        list.add(4.0);
        list.add(9.0);
//        list.add(34.0);
        list.add(25.0);
//        list.add(81.0);


        /**
         *   public interface BiFunction<T, U, R> {
         *  *          R apply(T var1, U var2);
         *  *     }
         *
         *  d1 = 1
         */
        BiFunction<Double, Double, Double> function = (d1, d2) -> d1*Math.sqrt(d2);


        /**
         * res = (1 * sqrt(4)) * (1 * sqrt(9)) * (1 * sqrt(25)) = 30
         *
         * identity = 2
         *
         * res = (2 * sqrt(4)) * (2 * sqrt(9)) * (2 * sqrt(25)) = 240
         */
        Double res = list.parallelStream()
                .reduce(2.0,
                        /**
                         * aDouble = 1
                         */
                        ((aDouble, aDouble2) -> aDouble * Math.sqrt(aDouble2)),
                        //function,
                        ((aDouble, aDouble2) -> aDouble * aDouble2));

        System.out.println("Result - " + res);//Result - 6.0

        Double res1 = list.parallelStream()
                .reduce(1.0,
                        ((aDouble, aDouble2) -> aDouble * Math.sqrt(aDouble2)));

        System.out.println("Result - " + res1); //Result - 3.4641016151377544 -> replace parallelStream in sequential


    }
}
