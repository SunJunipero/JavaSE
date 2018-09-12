package sinSum;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinRun {
    public static void main(String[] args) {
        ForkJoinPool fjp = new ForkJoinPool();

        int[] ints = Commons.prepareArr();

        long l = System.currentTimeMillis();
        Double res = fjp.invoke(new MyTask(ints, 0, ints.length));
        System.out.println("Time = " + ( System.currentTimeMillis() - l));

        System.out.println("sum = " + res);

        fjp.shutdown();


    }
}

class MyTask extends RecursiveTask<Double>{
    private static final int THRESHOLD = 50_000;

    private int[] arr;
    private int from;
    private int to;

    public MyTask(int[] arr, int from, int to) {
        this.arr = arr;
        this.from = from;
        this.to = to;
    }

    @Override
    protected Double compute() {
        if (to - from <= THRESHOLD){
            return Commons.calculate(arr, from, to);
        }
        else {
            int middle = (to - from) / 2;
            MyTask subtask1 = new MyTask(arr, from, middle);
            MyTask subtask2 = new MyTask(arr, middle, to);
            invokeAll(subtask1, subtask2);
            return subtask1.join() + subtask2.join();
        }
    }
}