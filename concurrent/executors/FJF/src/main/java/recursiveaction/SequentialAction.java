package recursiveaction;

public class SequentialAction {
    private double arr[];
    private int start;
    private int end;

    public SequentialAction(double[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    public void sqrtTransform(){
        for (int i = start; i < end; i++) {
            arr[i] = Math.sqrt(arr[i]);
        }
    }
}
