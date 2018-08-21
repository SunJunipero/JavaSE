package com.fi.example.BiPredicate;


import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

/**
 * public interface BiPredicate<T, U> {
 *     boolean test(T var1, U var2)
 *
 *     default BiPredicate<T, U> and(BiPredicate<? super T, ? super U> var1)
 *
 *
 *     default BiPredicate<T, U> negate()
 *
 *
 *     default BiPredicate<T, U> or(BiPredicate<? super T, ? super U> var1)
 *
 */
public class BiPredicateExample {
    public static void main(String[] args) {
        BiPredicate<String, Integer> predicate = ((s, i) -> s.length() == i );

        ArrayList<String> list = new ArrayList<>();

        list.add("dfds");
        list.add("dfd4s");
        list.add("dfd53s");
        list.add("dfd53s");
        list.add("dfd53s");
        list.add("dfd43423s");
        list.add("dfd4234s");
        list.add("dfd53s");

        int i = countSameLength(predicate, list, 6);

        System.out.println(i);

    }

    static int countSameLength(BiPredicate<String, Integer> predicate, List<String> strs, int lenght){
            int res = 0;
        for (String str : strs) {
            if (predicate.test(str, lenght)) {
                res++;
            }
        }
        return res;
    }
}
