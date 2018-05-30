import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Task {

    static <T> Set<T> symmetricDifference (Set<? extends T > set1, Set<? extends T> set2){
        Set<T> temp = new HashSet<>(set1);
        temp.addAll(set2);

        temp.removeIf(next -> set1.contains(next) && set2.contains(next));

        System.out.println(temp);

//        set1.retainAll(set2);
//        temp.removeAll(set1);
//        //set2.removeAll(set1);
//        temp.addAll(set2);
//        temp.removeAll(set1);
        return temp;
    }
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("3");
        HashSet<Integer> integers = new HashSet<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        HashSet<String> hashSet1 = new HashSet<>();
        HashSet<Double> doubles = new HashSet<>();
        doubles.add(0.0);
        doubles.add(1.0);
        doubles.add(2.0);
        hashSet1.add("0");
        hashSet1.add("1");
        hashSet1.add("2");

        Set<String> stringSet = symmetricDifference(hashSet, hashSet1);
        System.out.println(stringSet);
//        Set<? extends Number> numbers = symmetricDifference(integers, doubles);
//        System.out.println(numbers);

        //HashSet<String> temp = new HashSet<>(hashSet);

//        hashSet.retainAll(hashSet1);
//        System.out.println(hashSet);
//
//        temp.removeAll(hashSet);
//        hashSet1.removeAll(hashSet);
//
//        System.out.println("\t\tres");
//
//        System.out.println(temp);
//        System.out.println(hashSet1);
//
//        System.out.println("\t\tfinal");
//
//        temp.addAll(hashSet1);
//        System.out.println(temp);


    }
}
