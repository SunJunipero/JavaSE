package UsingCF.reading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Exchanger;

/**
 * boolean isDone()
 * boolean isCancelled()
 * boolean isCompletedExceptionally()
 * T get()
 * T join()
 * T get(long timeout, TimeUnit unit)
 * T getNow(T valueIfAbsent)
 * int getNumberOfDependents()
 */
public class ReadingDemo {
    public static void main(String[] args) {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("future");
        printInfo(cf);

        CompletableFuture<String> cf2 = cf.thenApply((s -> s + " apply 1"))
                                            .thenApply(s -> s + " apply 2" )
                                            .thenApply(s -> s + " apply 3");

        printInfo(cf2);

        //Suggest exception
        String s = "initial";
        CompletableFuture<String> cf3 = CompletableFuture.supplyAsync(() -> s + " (supply)");

        cf3.completeExceptionally(new RuntimeException(" OOPS !!!"));

        printInfo(cf3);
    }

    static void printInfo(CompletableFuture cf){
        System.out.println("is done - " + cf.isDone());
        System.out.println("is completed exceptionally - " + cf.isCompletedExceptionally());
        System.out.println("is cancelled - " + cf.isCancelled());

        cf.exceptionally((th) -> ((Exception) th).getMessage()).
                thenAccept(s -> System.out.println("value = " + s) );

        System.out.println("Number Of Dependents - " + cf.getNumberOfDependents());
        System.out.println("\t\t ----------------");
    }
}
