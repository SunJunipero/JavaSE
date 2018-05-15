import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();

        /**
         * We may put null in Set
         */

        hashSet.add(null);
        //get method is absent. Contains only.
        System.out.println(hashSet.contains(null));

        /**
         * HashSet is disorderly collection
         *
         * out:
             null
             Miles
             Alex
             Jamie
             Nick
             Math
         */

        hashSet.add("Alex");
        hashSet.add("Nick");
        hashSet.add("Jamie");
        hashSet.add("Math");
        hashSet.add("Miles");

        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("size of hashSet - " + hashSet.size());


    }
}
