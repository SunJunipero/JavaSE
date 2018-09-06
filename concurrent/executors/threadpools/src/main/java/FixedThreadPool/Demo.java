package FixedThreadPool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    public static void main(String[] args) {
        CountDownLatch latch1 = new CountDownLatch(5);
        CountDownLatch latch2 = new CountDownLatch(5);
        CountDownLatch latch3 = new CountDownLatch(5);
        CountDownLatch latch4 = new CountDownLatch(5);

        ExecutorService es = Executors.newFixedThreadPool(2);

        es.submit(new MyThread(latch1, "Thread1"));
        es.submit(new MyThread(latch2, "Thread2"));
        es.submit(new MyThread(latch3, "Thread3"));
        es.submit(new MyThread(latch4, "Thread4"));

        try {
            latch1.await();
            System.out.println("latch1 - " + latch1.getCount());
            latch2.await();
            System.out.println("latch2 - " + latch2.getCount());
            latch3.await();
            System.out.println("latch3 - " + latch3.getCount());
            latch4.await();
            System.out.println("latch4 - " + latch4.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        es.shutdown();

        System.out.println("Executor service finished");
    }
}
