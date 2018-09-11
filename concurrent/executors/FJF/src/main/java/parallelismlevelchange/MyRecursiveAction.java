package parallelismlevelchange;

import java.util.concurrent.RecursiveAction;

public class MyRecursiveAction extends RecursiveAction {
    private double[] arr;
    private int start;
    private int end;
    private int threshold = 1_000;

    public MyRecursiveAction(double[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if ((end - start) <= threshold){
            for (int i = start; i < end; i++) {
//                if(arr[i] % 2 == 0)
//                    arr[i] = Math.sqrt(arr[i]);
//               else
                    arr[i] = Math.cbrt(arr[i]);
            }
        }
        else {
            int middle = end - start;
            invokeAll(new MyRecursiveAction(arr, start, middle),
                    new MyRecursiveAction(arr, middle, end));
        }
    }
}
