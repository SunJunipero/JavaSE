package Arrays;

import java.util.Arrays;
import java.util.List;

public class ArraysExample {

    public static void main(String[] args) {
        Custom[] arr = {new Custom(3),
                new Custom(6),
                new Custom(12),
                new Custom(98),
                new Custom(43),
                new Custom(29),
                new Custom(75),
                new Custom(43),

        };

        for (Custom custom : arr){
            System.out.print(custom.i + " ");
        }
        System.out.println();

        Arrays.sort(arr);

        for (Custom custom : arr){
            System.out.print(custom.i + " ");
        }
        System.out.println();

        int i = Arrays.binarySearch(arr, new Custom(3));
        System.out.println("INdex = " +  i);


    }
}

class Custom implements Comparable<Custom>{
    int i;

    Custom(int i ){
        this.i = i;
    }

    @Override
    public String toString() {
        return String.valueOf(i);
    }

    @Override
    public int compareTo(Custom o) {
        return this.i - o.i;
    }
}

