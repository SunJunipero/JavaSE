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
         * -equals
         * -hashCode
         * -removeAll
         * -retainAll
         * -toArray
         * -toArray(T[] a)
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
         * contains and containAll
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
         * @See EqualsAndHashCodeAllCollections
         */

        /**
         * removeAll
         */
        System.out.println("\tremoveAll method ");
        System.out.println(collectionHashSet);//[null, val 7, val 3, val 5, val 1, val 2]
        List<String> removeAllList = Arrays.asList("val 1", "val 3", "val 7");
        boolean b = collectionHashSet.removeAll(removeAllList);
        System.out.println(b);//true
        System.out.println(collectionHashSet);//[null, val 5, val 2]

        /**
         *retainAll
         */
        System.out.println("\tretainAll method ");
        List<String> retainsAllList = Arrays.asList(null, null, "val 5", "val 2", "val 6");
        boolean b1 = collectionHashSet.retainAll(retainsAllList);
        System.out.println(b1);//true
        System.out.println(collectionHashSet);//[null, val 5, val 2]

        /**
         * toArray
         */
        System.out.println("\ttoArray method ");
        Object[] objects = collectionHashSet.toArray();

        for (Object object : objects) {
            System.out.println(object);
        }

        /**
         * toArray(T[] a)
         */
        System.out.println("\ttoArray(T[] a) method ");
        String[] strArr = new String[1];
        System.out.println("String[] strArr - " + strArr.length);//1
        String[] strings1 = collectionHashSet.toArray(strArr);
        System.out.println("String[] strings1 - " + strings1.length);//3
        /*
        null
        val 5
        val 2
         */
        for (String s : strings1) {
            System.out.println(s);
        }
        System.out.println("if array is not empty");
        String[] strValArr = new String[]{"1","3","5"};
        String[] strings2 = collectionHashSet.toArray(strValArr);
        System.out.println(strings2.length);
        for (String s : strings2) {
            System.out.println(s);
        }
        /*
            null
            val 5
            val 2
         */


    }

}
