import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class ListIteratorexample {
    public static void main(String[] args) {
        ListIterator<String> listIterator;
        Iterator<String> iterator;
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));

        System.out.println("Iterator");
        iterator = strings.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("listIterator");
        listIterator =  strings.listIterator(strings.size());
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }
}
