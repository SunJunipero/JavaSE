package recursiveaction;

import java.util.concurrent.RecursiveAction;

public class MyAction extends RecursiveAction {
    double[] arr;
    int start;
    int end;

    private final int threshold = 1_000;

    public MyAction(double[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - start <= threshold){
            for (int i = start; i < end; i++) {
                arr[i] = Math.sqrt(arr[i]);
            }
        }
        else {
            int middle = (end + start) / 2;
            invokeAll(new MyAction(arr, start, middle), new MyAction(arr, middle, end));

        }
    }
}
