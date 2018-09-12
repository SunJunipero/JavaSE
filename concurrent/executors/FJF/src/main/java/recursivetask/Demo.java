package recursivetask;
import java.util.concurrent.ForkJoinPool;

public class Demo {
    public static void main(String[] args) {
        ForkJoinPool fjp = new ForkJoinPool();
        //ForkJoinPool fjp = ForkJoinPool.commonPool();

        int[] arr = new int [30_000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        MyTask myTask = new MyTask(arr, 0, arr.length);

        fjp.execute(myTask);

        while (!myTask.isDone()){
            System.out.println(fjp);
        }

        //Integer sum = fjp.invoke(myTask);

        //System.out.println("sum = " + sum);
        System.out.println("isCancelled - " + myTask.isCancelled());
        System.out.println("isCompletedNormally - " + myTask.isCompletedNormally());
       // System.out.println("inForkJoinPool - " + MyTask.inForkJoinPool());

        /**
         * run again - OK
         */
        Integer su1m = fjp.invoke(myTask);

        System.out.println("sum " +  su1m);

    }
}

