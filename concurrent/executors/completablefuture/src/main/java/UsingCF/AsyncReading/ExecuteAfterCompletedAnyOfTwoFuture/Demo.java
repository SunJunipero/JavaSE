package UsingCF.AsyncReading.ExecuteAfterCompletedAnyOfTwoFuture;

import javax.management.remote.rmi.RMIConnectionImpl_Stub;
import java.util.concurrent.CompletableFuture;

/**
 * <U> CompletableFuture<U> applyToEither(CompletableFuture<? extends T> other, Function<? super T,U> fn)
 * CompletableFuture<Void> acceptEither(CompletableFuture<? extends T> other, Consumer<? super T> block)
 * CompletableFuture<Void> runAfterEither(CompletableFuture<?> other, Runnable action)
 *
 */
public class Demo {
    public static void main(String[] args) {
        String s = "initial string";

        /**
         * Return
         * join = INITIAL STRING SUPPLY
         * OR
         * join = INITIAL STRING ANOTHER SUPPLY
         */
        String join = CompletableFuture.supplyAsync(() -> s + " supply")
                .applyToEither(CompletableFuture.supplyAsync(() -> s + " another supply"),
                        s1 -> {
                            System.out.println(s1);
                            return s1.toUpperCase();
                        })
                .join();
        System.out.println("join = "+ join);

        /**
         * It's like
         */

        String join1 = CompletableFuture.anyOf(CompletableFuture.supplyAsync(() -> s + " supply"),
                CompletableFuture.supplyAsync(() -> s + " another supply"))
                .thenApply(o -> ((String) o).toUpperCase())
                .join();

        System.out.println("join1 = "+ join1);




    }
}

