package UsingCF.recording;

import java.util.concurrent.CompletableFuture;

/**
 * boolean complete(T value)
 * boolean completeExceptionally(Throwable ex)
 * boolean cancel(boolean mayInterruptIfRunning)
 * static <U> CompletableFuture<U> completedFuture(U value)
 */
public class RecordingDemo {
    public static void main(String[] args) {
        CompletableFuture<String> cf = new CompletableFuture<>();

        /**
         * complete demonstration
         */
        cf.complete("new value");
        printInfo(cf);

        /**
         * completedFuture demonstration
         */
        CompletableFuture<String> cf2 = CompletableFuture.completedFuture("completed value");
        printInfo(cf2);

        /**
         * completeExceptionally demonstration
         *
         */
        CompletableFuture<String> cf3 = CompletableFuture.completedFuture("record exception");
        cf3.completeExceptionally(new RuntimeException("bang-bang"));
        printInfo(cf3);
        //TODO handle method


    }

    static void printInfo(CompletableFuture cf){
        System.out.println("is done - " + cf.isDone());
        System.out.println("value -" + cf.join());
        System.out.println("\t\t ----------------");
    }
}
