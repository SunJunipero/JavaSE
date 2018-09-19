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
        //thenApplyExample();

        /**
         * thenApplyAsyncExample
         */
        //thenApplyAsyncExample();

        /**
         * thenApplyAsyncExecutorExample
         */
        //thenApplyAsyncExecutorExample();

        /**
         * thenAcceptExample
         */
        thenAcceptExample();

        /**
         * thenAcceptAsyncExample
         */
        thenAcceptAsyncExample();

        /**
         * completeExceptionallyExample
         */
        //completeExceptionallyExample();

        /**
         * cancelExample
         */

        //cancelExample();

        /**
         * applyToEitherExample
         */
        //applyToEitherExample();

        /**
         * acceptEitherExample
         */
        //acceptEitherExample();

        /**
         * runAfterBothExample
         */
        //runAfterBothExample();

        /**
         * runAfterBothExample
         */
        //runAfterBothExample();

        /**
         * thenAcceptBothExample
         */
        //thenAcceptBothExample();

        //composeVsThenApply();

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

    static int fac(int n ){
        if(n == 1) return 1;
        return n *  fac( n - 1);
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

    static void thenApplyAsyncExecutorExample(){
        ExecutorService pool = Executors.newFixedThreadPool(3, (runnable)->{
            int count = 0;
            return new Thread(runnable, "custom thread " + count++);
        });

        CompletableFuture<Integer> cf = CompletableFuture.completedFuture(10).thenApplyAsync(integer -> {
            System.out.println("name - " + Thread.currentThread().getName());
            System.out.println("is Daemon - " + Thread.currentThread().isDaemon());
            return fib(integer);
        }, pool);
        System.out.println("is done = " + cf.isDone());
        System.out.println("res = " + cf.join());
        System.out.println("is done = " + cf.isDone());

        pool.shutdown();

    }

    static void thenAcceptExample(){
        StringBuilder builder = new StringBuilder();

        CompletableFuture cf = CompletableFuture.completedFuture("thenAccept ").thenAccept(builder::append);
        System.out.println("is done = " + cf.isDone());
        System.out.println("res = " + builder);
        System.out.println("is done = " + cf.isDone());

    }

    static void thenAcceptAsyncExample(){
        StringBuilder builder = new StringBuilder();

        CompletableFuture cf = CompletableFuture.completedFuture("thenAccept ").thenAcceptAsync(builder::append);
        System.out.println("is done = " + cf.isDone());
        cf.join();
        System.out.println("res = " + builder);
        System.out.println("is done = " + cf.isDone());
    }

    static void completeExceptionallyExample(){
        CompletableFuture<String> cf = CompletableFuture.completedFuture("text message").thenApplyAsync(String::toUpperCase,
                CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS));

        CompletableFuture handle = cf.handle((s, th) -> {
            System.out.println(" s = " + s);
            System.out.println(" throwable message = " + th.getMessage());
            return (th != null) ? "message upon cancel" : "";
        });

        cf.completeExceptionally(new RuntimeException("completed exceptionally"));
        //cf.completeExceptionally(new RuntimeException("completed exceptionally"));

        System.out.println("isCompletedExceptionally = " + cf.isCompletedExceptionally());

        try {
            String res = cf.join();
            System.out.println("res - " + res);
        } catch (CompletionException ex) {
            System.out.println("exception message - " + ex.getCause().getMessage());
        }
    }

    static void cancelExample(){
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message").thenApplyAsync(String::toUpperCase,
                CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS));

        CompletableFuture<String> cf2 = cf.exceptionally(throwable -> "cancel message !!!");

        //cf.cancel(true);
        System.out.println("res = " + cf.join());
        System.out.println("isCompletedExceptionally = " + cf.isCompletedExceptionally());
        System.out.println("isCancelled = " + cf.isCancelled());
        System.out.println("exc message = " + cf2.join());

    }

    static void applyToEitherExample(){
        String s = "message";

        CompletableFuture<String> cf = CompletableFuture.completedFuture(s).thenApplyAsync(s1 -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("UpperCase stage");
            return s1.toUpperCase() + " stage 1";
        });

        CompletableFuture<String> cf2 = cf.applyToEither(CompletableFuture.completedFuture(s).thenApplyAsync(s1 -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("LowerCase stage");
            return s1.toLowerCase();
        }), s1 -> s1 + " applyToEither ");

        System.out.println("cf = " + cf.join());
        System.out.println("cf2 = " + cf2.join());
    }

    static void acceptEitherExample(){
        String s = "message";
        StringBuilder builder = new StringBuilder();

        CompletableFuture<String> cf = CompletableFuture.completedFuture(s).thenApplyAsync(s1 -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("UpperCase stage");
            return s1.toUpperCase() + " stage 1";
        });

        CompletableFuture<Void> cf2 = cf.acceptEither(CompletableFuture.completedFuture(s).thenApplyAsync(s1 -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("LowerCase stage");
            System.out.println("stage 2 = " + s1);
            return s1.toLowerCase();
        }), s1 -> builder.append(s1).append(" accept either"));

        System.out.println("cf = " + cf.join());
        System.out.println("builder - " + builder);

    }

    static void runAfterBothExample(){
        StringBuilder string = new StringBuilder("initial string");
        CompletableFuture.completedFuture(string).thenApply(stringBuilder -> stringBuilder.append(" stage 1"))
                .runAfterBoth(CompletableFuture.completedFuture(string).thenApply(stringBuilder -> stringBuilder.append(" stage 2")),
                        () -> string.append(" done"));

        System.out.println("res = " + string);

    }

    static void thenAcceptBothExample(){
        String string = "initial string";
        StringBuilder result = new StringBuilder();
        CompletableFuture.completedFuture(string).thenApply(String::toUpperCase)
                .thenAcceptBoth(CompletableFuture.completedFuture(string).thenApply(String::toLowerCase),
                        ((string1, string2) -> {
                            System.out.println(string1);
                            System.out.println(string2);
                            result.append(string1).append(string2);
                        }));

        System.out.println("result = " + result);
    }

    static void composeVsThenApply(){
        /**
         *    public <U> CompletableFuture<U> thenCompose(
         *         Function<? super T, ? extends CompletionStage<U>> fn) {
         *         return uniComposeStage(null, fn);
         *     }
         */
        CompletableFuture<Long> cf = CompletableFuture.supplyAsync(() -> 42L)
                .thenCompose(x -> CompletableFuture.supplyAsync(() -> x + 2017));

        System.out.println("cf (compose) = " + cf.join());

        /**
         * public <U> CompletableFuture<U> thenApply(
         *         Function<? super T,? extends U> fn) {
         *         return uniApplyStage(null, fn);
         *     }
         */
        CompletableFuture<CompletableFuture<Long>> cf2 = CompletableFuture.supplyAsync(() -> 42L)
                .thenApply(x -> CompletableFuture.supplyAsync(() -> x + 2017));

        System.out.println("cf2 (thenApply) = " + cf2.join().join());


    }






}
