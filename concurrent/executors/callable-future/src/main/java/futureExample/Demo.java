package futureExample;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class Demo {
    public static void main(String[] args) {
        Future<Integer> f1;
        Future<Integer> f2;

        ExecutorService es = Executors.newFixedThreadPool(2);

        f1 = es.submit(new CallableFactorial(5));
        f2 = es.submit(new CallableSum(10 , 32));

        try {
            System.out.println("factorial = " + f1.get());
            System.out.println("sum = " + f2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        es.shutdown();

        System.out.println("FINISHED");


    }

}
