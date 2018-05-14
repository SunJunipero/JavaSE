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
            if(iterator.next() % 2 == 0 && iterator.next() != 0)
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


    }
}
