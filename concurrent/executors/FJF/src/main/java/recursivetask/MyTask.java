package recursivetask;

import java.util.concurrent.RecursiveTask;

public class MyTask extends RecursiveTask<Integer> {
    int[] arr;
    int start;
    int end;

    private final int threshold = 500;

    public MyTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        if ((end - start) <= threshold){
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
        }
        else{
            int middle = (start + end) / 2;
            MyTask task1 = new MyTask(arr, start, middle);
            MyTask task2 = new MyTask(arr, middle, end);

            task1.fork();
            task2.fork();

            sum = task1.join() + task2.join();
        }
        return sum;
    }
}
