package UsingCF.AsyncRecording;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier)
 * static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier, Executor executor)
 * static CompletableFuture<Void> runAsync(Runnable runnable)
 * static CompletableFuture<Void> runAsync(Runnable runnable, Executor executor)
 */
public class AsyncRecordingDemo {

    static Random random = new Random();
    public static void main(String[] args) {

        /**
         * is done - false
         * thread name - ForkJoinPool.commonPool-worker-1
         * is done (after sleep) - true
         * is completed exceptionally - false
         * is cancelled - false
         * value - 3628800
         */
        CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println("thread name - " + Thread.currentThread().getName());
            randomSleep();
            return fac(10);
        });
        printInfo(cf);


        /**
         * is done - false
         * thread name - pool-1-thread-1
         * is done (after sleep) - true
         * is completed exceptionally - false
         * is cancelled - false
         * value - 3628800
         */
        ExecutorService es = Executors.newFixedThreadPool(3);
        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("thread name - " + Thread.currentThread().getName());
            randomSleep();
            return fac(10);
        }, es);
        es.shutdown();
        printInfo(cf2);

        CompletableFuture<Void> cf3 = CompletableFuture.runAsync(() -> {
            System.out.println(fib(30));
        });

        printInfo(cf3);


    }

    static int fib(int n ){
        if(n == 1) return 1;
        if(n == 2) return 1;
        return fib(n - 1) + fib( n - 2);
    }

    static int fac(int n ){
        if(n == 1) return 1;
        return n *  fac( n - 1);
    }

    static void randomSleep(){
        try {
            Thread.sleep(random.nextInt(1_000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void longSleep(){
        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void printInfo(CompletableFuture cf){
        System.out.println("is done - " + cf.isDone());
        longSleep();
        System.out.println("is done (after sleep) - " + cf.isDone());
        System.out.println("is completed exceptionally - " + cf.isCompletedExceptionally());
        System.out.println("is cancelled - " + cf.isCancelled());
        System.out.println("value - " + cf.join());
        System.out.println("\t\t ----------------");
    }
}
