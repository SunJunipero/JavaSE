import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class FromIterableToHashSet {
    public static void main(String[] args) {

        /**    ----< Iterable >----
         * iterator method available only
         */
        Iterable<String> hashSet = new HashSet<>();

        /**    ----< Collection >----
         * -add
         * -size
         * -addAll
         * -clear
         * -isEmpty
         * -contains
         * -containsAll
         *
         */

        Collection<String> collectionHashSet = new HashSet<>();
        /**
         * add
         */

        collectionHashSet.add("val 1");
        collectionHashSet.add("val 2");
        collectionHashSet.add(null);
        collectionHashSet.add("val 3");
        collectionHashSet.add("val 2");
        System.out.println("We put 5 elements, two of them are SAME and one is null. Collection's size " +
                "must be 4 ");
        System.out.println(collectionHashSet.size());

        /**
         * addAll
         * Size of collection HashSet will be 6, because element with null and "val 3" are repeated
         */
        ArrayList<String> strings = new ArrayList<>();
        strings.add("val 3");
        strings.add("val 5");
        strings.add("val 7");
        strings.add(null);
        strings.add(null);
        System.out.println(strings.size());
        collectionHashSet.addAll(strings);
        System.out.println(collectionHashSet.size());

        /**
         * clear
         * Remove all elements from collection, isEmpty method return true
         */

        //collectionHashSet.clear();
        System.out.println(collectionHashSet.isEmpty());

        /**
         * contains ans containAll
         */
        System.out.println(collectionHashSet.contains("val 7"));
        //testHashSet contains same values as in string from addAll method example
        HashSet<String> testHashSet = new HashSet<>();
        testHashSet.add(null);
        testHashSet.add("val 7");
        testHashSet.add("val 5");
        testHashSet.add("val 3");
        System.out.println(collectionHashSet.containsAll(testHashSet)); //true

        /**
         * Equals and hashCode
         *
         * Collections with common interfaces, like Set, List, Queue, return true and same hashcode.
         */
        System.out.println(collectionHashSet);
        List<String> stringList =  Arrays.asList("val 7", "val 5", "val 3", "val 1", "val 2", null);
        System.out.println(stringList);
        System.out.println(collectionHashSet.equals(stringList));//false

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(stringList);
        System.out.println(linkedHashSet);
        System.out.println(linkedHashSet.equals(stringList));//false
        System.out.println("linkedHashSet and collectionHashSet " + linkedHashSet.equals(collectionHashSet));//true

        HashSet<String> equalsHashSet = new HashSet<>(collectionHashSet);
        System.out.println(equalsHashSet);
        System.out.println(collectionHashSet.equals(equalsHashSet));//true

        System.out.println("collectionHashSet - " + collectionHashSet.hashCode());
        System.out.println("equalsHashSet - " + equalsHashSet.hashCode());
        System.out.println("linkedHashSet - " + linkedHashSet.hashCode());
        System.out.println("stringList - " + stringList.hashCode());


    }

}
