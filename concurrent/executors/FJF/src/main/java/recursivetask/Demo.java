package recursivetask;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class Demo {
    public static void main(String[] args) {
        ForkJoinPool fjp = new ForkJoinPool();

        int[] arr = new int [30];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        MyTask myTask = new MyTask(arr, 0, arr.length);

        Integer sum = fjp.invoke(myTask);

        System.out.println("sum = " + sum);



    }
}
