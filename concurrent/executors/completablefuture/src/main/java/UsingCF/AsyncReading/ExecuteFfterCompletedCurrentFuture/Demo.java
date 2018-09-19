package UsingCF.AsyncReading.ExecuteFfterCompletedCurrentFuture;

import java.math.BigInteger;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <U> CompletableFuture<U> thenApply(Function<? super T,? extends U> fn)
 * CompletableFuture<Void> thenAccept(Consumer<? super T> block)
 * CompletableFuture<Void> thenRun(Runnable action)
 * <U> CompletableFuture<U> thenCompose(Function<? super T, CompletableFuture<U>> fn)
 */
public class Demo {
    public static void main(String[] args) {
        /**
         *           thenApply
         * is done - true
         * is done (after sleep) - true
         * is completed exceptionally - false
         * is cancelled - false
         * value - 1904
         *
         */
        runThenApply();
        /**
         *          thenApplyAsync
         * is done - false
         * is done (after sleep) - true
         * is completed exceptionally - false
         * is cancelled - false
         * value - 1904
         */
        runThenApplyAsync();


        /**
         * true
         * initial string
         */
        runAccept();
        System.out.println("-------");

        /**
         * false
         * initial string async
         * true
         */
         runAcceptAsync();
        System.out.println("-------");

        /**
         * main
         */
        runRun();

        /**
         * pool-1-thread-1
         */
        runRunAsync();
        System.out.println("-------");
        /**
         *res compose = 2043
         * res apply = java.util.concurrent.CompletableFuture@6cd8737[Completed normally]
         */
        runCompose();


    }

    static void runThenApply(){
        CompletableFuture<BigInteger> cf = CompletableFuture.supplyAsync(() -> fac(10))
                .thenApply(integer -> new BigInteger(String.valueOf(integer)).sqrt());
        printInfo(cf);
    }

    static void runThenApplyAsync(){
        CompletableFuture<BigInteger> cf = CompletableFuture.supplyAsync(() -> fac(10))
                .thenApplyAsync(integer -> new BigInteger(String.valueOf(integer)).sqrt());
        printInfo(cf);
    }

    static void runAccept(){
        StringBuilder builder = new StringBuilder();
        CompletableFuture cf = CompletableFuture.completedFuture("initial string")
                .thenAccept(builder::append);
        System.out.println(cf.isDone());
        System.out.println(builder);
    }

    static void runAcceptAsync(){
        StringBuilder builder = new StringBuilder();
        CompletableFuture cf = CompletableFuture.completedFuture("initial string async")
                .thenAcceptAsync(builder::append);
        System.out.println(cf.isDone());
        cf.join();
        System.out.println(builder);
        System.out.println(cf.isDone());
    }

    static void runRun(){
        CompletableFuture<Void> cf = CompletableFuture.completedFuture("execute run")
                .thenRun(() -> System.out.println(Thread.currentThread().getName()));
    }
    static void runRunAsync(){
        ExecutorService es = Executors.newFixedThreadPool(2);
        CompletableFuture<Void> cf = CompletableFuture.completedFuture("execute run")
                .thenRunAsync(() -> System.out.println(Thread.currentThread().getName()), es);

        es.shutdown();
    }

    static void runCompose(){
        /**
         *    public <U> CompletableFuture<U> thenCompose(
         *         Function<? super T, ? extends CompletionStage<U>> fn) {
         *         return uniComposeStage(null, fn);
         *     }
         */
        CompletableFuture<Long> cf =
                CompletableFuture.completedFuture(43L).thenCompose(aLong ->
                CompletableFuture.supplyAsync(()-> aLong + 2_000L));

        System.out.println("res compose = " + cf.join());

        /**
         *   public <U> CompletableFuture<U> thenApply(
         *         Function<? super T,? extends U> fn) {
         *         return uniApplyStage(null, fn);
         *     }
         */
        CompletableFuture<CompletableFuture<Long>> cfcf = CompletableFuture.completedFuture(43L).thenApply(aLong ->
                CompletableFuture.supplyAsync(() -> aLong + 2_000L));
        System.out.println("res apply = " + cfcf.join());


    }

    static int fac(int n ){
        if(n == 1) return 1;
        return n *  fac( n - 1);
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
       // longSleep();
        System.out.println("is done (after sleep) - " + cf.isDone());
        System.out.println("is completed exceptionally - " + cf.isCompletedExceptionally());
        System.out.println("is cancelled - " + cf.isCancelled());
        System.out.println("value - " + cf.join());
        System.out.println("\t\t ----------------");
    }
}
