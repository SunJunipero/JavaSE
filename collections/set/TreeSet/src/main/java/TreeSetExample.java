import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        /**
         * We cant put null in TreeSet, because insert run through compare,
         * and if try put null, we'll het NPE
         */
        treeSet.add("lol");
        //NPE
        //System.out.println(treeSet.contains(null));
        System.out.println(treeSet.contains("lol"));
        System.out.println(treeSet.contains("loll"));
        System.out.println(treeSet.first());

        /**
         * treeSet is sorted collection. because TreeSet sorts element as soon
         * as you add it into TreeSet, if the object is null then calling compareTo()
         * on that will throw NullPointerException.
         *
         * out
         Alex
         Jamie
         Math
         Miles
         Nick
         lol
         */
        treeSet.add("Alex");
        treeSet.add("Nick");
        treeSet.add("Jamie");
        treeSet.add("Math");
        treeSet.add("Miles");

        Iterator<String> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
