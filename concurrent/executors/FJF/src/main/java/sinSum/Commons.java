package sinSum;

public class Commons {
    static public int[] prepareArr(){
        int[] arr = new int[20_000_000];
        //int[] arr = new int[1_000_000];
       // int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        return arr;
    }
    static public double calculate(int[] arr){
        return calculate(arr, 0, arr.length);
    }

    static public double calculate(int[] arr, int start, int end){
        double sum = 0;

        for (int i = start; i < end; i++) {
            sum += func(arr[i]);
        }
        return sum;
    }

    static final double func(int val){
        return Math.sin(val);
    }
}
