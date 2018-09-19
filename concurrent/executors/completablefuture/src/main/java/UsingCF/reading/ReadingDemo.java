package UsingCF.reading;

import java.util.concurrent.CompletableFuture;

/**
 * boolean isDone()
 * boolean isCancelled()
 * boolean isCompletedExceptionally()
 * T get()
 * T join()
 * T get(long timeout, TimeUnit unit)
 * T getNow(T valueIfAbsent)
 * int getNumberOfDependents() //TODO
 */
public class ReadingDemo {
    public static void main(String[] args) {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("future");
        printInfo(cf);

        CompletableFuture<String> cf2 = cf.thenApply((s -> s + " apply 1"))
                                            .thenApply(s -> s + " apply 2" )
                                            .thenApply(s -> s + " apply 3");

        printInfo(cf2);


    }

    static void printInfo(CompletableFuture cf){
        System.out.println("is done - " + cf.isDone());
        System.out.println("is completed exceptionally - " + cf.isCompletedExceptionally());
        System.out.println("is cancelled - " + cf.isCancelled());
        System.out.println("value - " + cf.join());
        System.out.println("Number Of Dependents - " + cf.getNumberOfDependents());
        System.out.println("\t\t ----------------");
    }
}
