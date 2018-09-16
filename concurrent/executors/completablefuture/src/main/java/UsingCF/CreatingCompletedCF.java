package UsingCF;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

/**
 * - completedFuture
 * - allof
 * - anyOf
 * - runAsync
 * - supplyAsync
 */
public class CreatingCompletedCF {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /**
         * CompletableFuture.completedFuture
         */
        //createdCompletedFuture();

        /**
         * CompletableFuture.runAsync
         */
        //runAsyncExample();

        /**
         * CompletableFuture.runAsync (Executor)
         */
        //runAsyncESExample();

        /**
         * CompletableFuture.supplyAsync
         */
        //supplyAsync();

        /**
         * thenApplyExample
         */
        thenApplyExample();

        /**
         * thenApplyAsyncExample
         */
        //thenApplyAsyncExample();

    }

    static void createdCompletedFuture() throws ExecutionException, InterruptedException {
        CompletableFuture future = CompletableFuture.completedFuture("this is completable future");
        assertTrue(future.isDone());
        assertEquals("this is completable future", future.get());
    }

    static void runAsyncExample() throws InterruptedException {

        CompletableFuture cf = CompletableFuture.runAsync(() -> {
            System.out.println("\t\tname - " + Thread.currentThread().getName());
            System.out.println("\t\tis daemon " + Thread.currentThread().isDaemon());
            /**
             * "Useful" load
             */
            Integer res = IntStream.range(1, 10)
                    .boxed()
                    .reduce((integer, integer2) -> integer * integer2)
                    .get();
            try {
                        Thread.sleep(1_500);
                System.out.println("factorial 10 = " + res);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );

        System.out.println("is done - " + cf.isDone());
        Thread.sleep(2_000);
        System.out.println("is done - " + cf.isDone());
    }

    static void runAsyncESExample() throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);

        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            System.out.println("\t\tname - " + Thread.currentThread().getName());
            System.out.println("\t\tis daemon " + Thread.currentThread().isDaemon());
            /**
             * "Useful" load
             */
            Integer res = IntStream.range(1, 10)
                    .boxed()
                    .reduce((integer, integer2) -> integer * integer2)
                    .get();
            try {
                Thread.sleep(1_500);
                System.out.println("factorial 10 = " + res);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, es);
        System.out.println("is done - " + cf.isDone());
        Thread.sleep(2_000);
        System.out.println("is done - " + cf.isDone());

        es.shutdown();
    }

    /**
     * "Useful" supplier
     */
    static int fib(int n ){
        if(n == 1) return 1;
        if(n == 2) return 1;
        return fib(n - 1) + fib( n - 2);
    }
    static void supplyAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> fib(10));
        System.out.println("is done - " + cf.isDone());
        System.out.println("fib(10) =  " + cf.get());
        System.out.println("is done - " + cf.isDone());
    }

    static void thenApplyExample(){
        CompletableFuture<Integer> cf = CompletableFuture.completedFuture(10).thenApply(integer -> {
            System.out.println("name - " + Thread.currentThread().getName());
            System.out.println("is Daemon - " + Thread.currentThread().isDaemon());
            return fib(integer);
        });

        System.out.println("is done = " + cf.isDone());
        System.out.println("res = " + cf.join());
        System.out.println("is done = " + cf.isDone());

    }

    /**
     *
     *Output
     * is done = false
     * name - ForkJoinPool.commonPool-worker-1
     * is Daemon - true
     * res = 55
     * is done = true
     */
    static void thenApplyAsyncExample() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> cf = CompletableFuture.completedFuture(10).thenApplyAsync(integer -> {
            System.out.println("name - " + Thread.currentThread().getName());
            System.out.println("is Daemon - " + Thread.currentThread().isDaemon());
            return fib(integer);
        });
        System.out.println("is done = " + cf.isDone());
        System.out.println("res = " + cf.join());
        System.out.println("is done = " + cf.isDone());
    }

}
