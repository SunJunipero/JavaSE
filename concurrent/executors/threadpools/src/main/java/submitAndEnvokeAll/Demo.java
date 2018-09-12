package submitAndEnvokeAll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Demo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //ExecutorService es = Executors.newCachedThreadPool();
        ExecutorService es = Executors.newFixedThreadPool(2);

        System.out.println("\t\t Through submit");

        Future<String> worker1 = es.submit(new Worker("worker1"));
        Future<String> worker2 = es.submit(new Worker("worker2"));

        try {
            System.out.println(worker1.get());
            System.out.println(worker2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("\t\t Through invokeAll");

        ArrayList<Worker> workers = new ArrayList<>();
        workers.add(new Worker("worker3"));
        workers.add(new Worker("worker4"));
        workers.add(new Worker("worker5"));
        workers.add(new Worker("worker6"));


            List<Future<String>> futures = es.invokeAll(workers);

        for (Future<String> future : futures) {
            System.out.println(future.get());
        }

        es.shutdown();

        es.awaitTermination(10l, TimeUnit.SECONDS);


    }
}
