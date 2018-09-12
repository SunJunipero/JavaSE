package parallelismlevelchange;

import java.util.concurrent.ForkJoinPool;

public class Demo {
    public static void main(String[] args) {
        ForkJoinPool fjp = new ForkJoinPool();

        double[] arr = new double[1_000_0];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        MyRecursiveAction action = new MyRecursiveAction(arr, 0, arr.length);

        long l = System.nanoTime();
        fjp.invoke(action);
        System.out.println("time = " + (System.nanoTime() - l));




    }
}
