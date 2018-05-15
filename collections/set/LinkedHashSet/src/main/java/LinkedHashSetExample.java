import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        /**
         * We may put null in Set
         */
        linkedHashSet.add(null);
        System.out.println(linkedHashSet.contains(null));
        System.out.println(linkedHashSet.isEmpty());

        /**
         * LinkedHashSet is orderly collection
         *
         * out
             null
             Alex
             Nick
             Jamie
             Math
             Miles
         */

        linkedHashSet.add("Alex");
        linkedHashSet.add("Nick");
        linkedHashSet.add("Jamie");
        linkedHashSet.add("Math");
        linkedHashSet.add("Miles");

        Iterator<String> iterator = linkedHashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("size of linkedHashSet - " + linkedHashSet.size());
    }
}
