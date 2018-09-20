package UsingCF.AsyncReading.ExecuteAfterCompletedTwoFuture;

import java.math.BigInteger;
import java.util.concurrent.CompletableFuture;

/**
 * <U,V> CompletableFuture<V>thenCombine(CompletionStage<? extends U> other, BiFunction<? super T,? super U,? extends V> fn)
 * <U> CompletableFuture<Void> thenAcceptBoth(CompletableFuture<? extends U> other, BiConsumer<? super T,? super U> block)
 * CompletableFuture<Void> runAfterBoth(CompletableFuture<?> other, Runnable action)
 *
 */
public class Demo {
    public static void main(String[] args) {

        /**
         * 8450550186924629495838157093855404565441366722012461965560414732385728621597296137876420884621412468214583850753160522570648517967532382305454834505647607520427964189812887040005874546880020480000000000000000000000000
         */
        //thenCombineExmaple();

        /**
         * 8450550186924629495838157093855404565441366722012461965560414732385728621597296137876420884621412468214583850753160522570648517967532382305454834505647607520427964189812887040005874546880020480000000000000000000000000
         */
        //System.out.println("res = " + thenAcceptBothExamole());

        runAfterBothExample();

    }

    static void thenCombineExmaple(){
        CompletableFuture.supplyAsync(()->fac(200))
                .thenCombine(CompletableFuture.supplyAsync(() -> fac(100)),
                        BigInteger::divide)
                .thenAccept(System.out::println);
    }

    static BigInteger thenAcceptBothExamole(){
        BigInteger[] integers = new BigInteger[1];

        CompletableFuture.supplyAsync(()->fac(200))
                .thenAcceptBoth(CompletableFuture.supplyAsync(() -> fac(100)),
                        ((bigInteger, bigInteger2) -> integers[0] = bigInteger.divide(bigInteger2)));
        return integers[0];
    }

    static void runAfterBothExample(){
        CompletableFuture.supplyAsync(() -> fac(200))
                .runAfterBothAsync(CompletableFuture.supplyAsync(() -> fac(100)),
                        () -> System.out.println("both completed"));
    }


    static BigInteger fac (int n){
        BigInteger res = BigInteger.ONE;
        while (n > 1){
            res = res.multiply(BigInteger.valueOf(n));
            n--;
        }
        return res;
    }
}
