package sinSum;

import java.util.concurrent.*;

public class ExecutorServiceRun {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);

        int[] ints = Commons.prepareArr();

        long l = System.currentTimeMillis();

        Future<Double> subtask1 = es.submit(new MyCalculate(ints, 0, ints.length/2));
        Future<Double> subtask2= es.submit(new MyCalculate(ints, ints.length / 2, ints.length ));

        double res = subtask1.get() + subtask2.get();

        System.out.println("Time = " + (System.currentTimeMillis() - l));
        System.out.println("sum = " + res);

        es.shutdown();
    }
}

class MyCalculate implements Callable<Double>{
    private int[] arr;
    private int from;
    private int to;

    public MyCalculate(int[] arr, int from, int to) {
        this.arr = arr;
        this.from = from;
        this.to = to;
    }

    @Override
    public Double call() throws Exception {
        return Commons.calculate(arr, from, to);
    }
}
