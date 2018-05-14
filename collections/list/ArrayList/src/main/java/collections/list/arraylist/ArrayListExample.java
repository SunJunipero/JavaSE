package collections.list.arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayListExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= 10; i++) {
            list.add(random.nextInt(i));
        }
        System.out.println(list);
    }
}
