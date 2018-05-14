import java.lang.reflect.Array;
import java.util.*;

public class CollectionExample {
    public static void main(String[] args) {
        Collection<Integer> collection  = new ArrayList<>();
        List<String> strings;
        Set<String> set;
        /*
        Synchronized collection
         */
        Vector<String> vector;
        /*
        Synchronized collection
         */
        Stack<String> stack;
        Queue<String> queue;
        Map<String, String> map = new HashMap<>();

        /*
         * Add
         */
        System.out.println("Add");
        collection.add(1);
        collection.add(2);
        System.out.println(collection.size());
        System.out.println(collection);

        /*
         * Remove
         */
        System.out.println("Remove");
        collection.remove(3);
        collection.remove(2);
        System.out.println(collection.size());
        System.out.println(collection);

        /*
        walk through iterator
         */
        System.out.println("Walk through iterator");
        Integer [] integers = new Integer[]{1,3,4,5,6};
        collection.addAll(Arrays.asList(integers));
        Iterator<Integer> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        /*
        walk through foreach
         */
        System.out.println("Walk through foreach");
        for (Integer integer : collection) {
            System.out.println(integer);
        }

        //TODO Map quiz
        /*
        add null keys in map
         */
        System.out.println("map quiz");
        map.put(null,"1");
        map.put(null,"2");
        map.put(null,"3");
        map.put(null,null);

        System.out.println(map.get(null));


    }
}
