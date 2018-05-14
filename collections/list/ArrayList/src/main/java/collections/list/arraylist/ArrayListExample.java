package collections.list.arraylist;


import java.util.*;

public class ArrayListExample {
    /*
    Contains all elements in simple array (Object[] elementData)
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= 10; i++) {
            list.add(random.nextInt(i));
        }
        System.out.println(list);

        /**
        Modify and iterate
         */
        /*
        EXCEPTION !!!
        ConcurrentModificationException. Needed used "classic for" or iterator
         */
//        System.out.println("Modify and iterate");
//        for (Integer integer : list) {
//            // or add
//            list.remove(0);
//        }

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            if((iterator.next() % 2 == 0) && (iterator.next() != 0))
               iterator.remove();
        }

        System.out.println("after modify");
        System.out.println(list);

        /**
         Sort
         */
        Collections.sort(list);
        System.out.println("After Collections.sort(list)");
        System.out.println(list);
        //if we have custom object, we need used Compare

        class CustomClass implements Comparable{
            int id;
            String name;

            CustomClass(int id, String name){
                this.id = id;
                this.name = name;

            }

            @Override
            public int compareTo(Object o) {
                return this.id - ((CustomClass) o).id;
            }

            @Override
            public String toString() {
                return "CustomClass{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        '}';
            }
        }

        List<CustomClass> classes = new ArrayList<>();
        classes.add(new CustomClass(12, "Alex"));
        classes.add(new CustomClass(14, "Math"));
        classes.add(new CustomClass(9, "Jamie"));
        classes.add(new CustomClass(3, "Nick"));

        Collections.sort(classes);
        System.out.println(classes);

        /**
         Binary search
         */
        /*
        If we want search necessary element in collection, we can use Collections.binarySearch()
         !!! BUT COLLECTION SHOULD BE SORTED
         */
        class ComparatorCustomClass implements Comparator<CustomClass>{
            @Override
            public int compare(CustomClass customClass, CustomClass t1) {
                return customClass.id - t1.id == 0 ? customClass.name.compareTo(t1.name) : customClass.id - t1.id;
            }
        }
        System.out.println("Binary search");
        int nick = Collections.binarySearch(classes, new CustomClass(12, "Alex"), new ComparatorCustomClass());
        System.out.println(nick);

        /**
         * List to array and back
         */


        String[] strings = new String[]{"1","7", "2","9", "3"};
        List<String> strings1 = Arrays.asList(strings);
        System.out.println(strings1);
        String[] strings2 = strings1.toArray(strings);
        for (String s : strings2) {
            System.out.println(s);
        }

        /**
         * Equals lists
         */
        // QUIZ QUESTION
        // We may compare list through equals THEREFOR we may use them as key in map, bit this is unsafe
        // because we may change values of list
        List<String> equalsList = Arrays.asList("1","7", "2","9", "3");
        System.out.println(strings1.equals(equalsList));
        List<String> nonEqualsList = Arrays.asList("1","7", "2","9", "3", "44");
        System.out.println(strings1.equals(nonEqualsList));

        Map<List<String>, String> map = new HashMap<>();
        List<String> nonEqualsList1 = Arrays.asList("1","7", "2","9", "3", "44");
        map.put(equalsList, "equalsList");
        map.put(nonEqualsList, "nonEqualsList");
        map.put(nonEqualsList1, "nonEqualsList1");

        System.out.println(map.size());
        Set<Map.Entry<List<String>, String>> entries = map.entrySet();
        Iterator<Map.Entry<List<String>, String>> entryIterator = entries.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<List<String>, String> entry= entryIterator.next();
            System.out.println(entry.getKey() + " --- " + entry.getValue());
        }

        Set<List<String>> lists = map.keySet();
        for (List<String> stringList : lists) {
            stringList.set(3, "loool");
        }

        System.out.println(map);

        /**
         * vector vs sync vs arraylist
         */
        //TODO compare this structure

        /**
         * add a lot of elements
         */
        // QUIZ QUESTION. What maximum number of elements we can add to ArrayList.
        // ArrayList and LinkedList contains field "int size". In theory, if we add more
        // than 2_000_000_000 elements, how we get them ? Because limit of int type 2 147 483 647.
        // In other hand, memory may run out (to escape this, we may tune VM options)


    }
}
