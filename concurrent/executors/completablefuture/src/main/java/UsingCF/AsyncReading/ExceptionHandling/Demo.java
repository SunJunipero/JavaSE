package UsingCF.AsyncReading.ExceptionHandling;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * CompletableFuture<T> exceptionally(Function<Throwable,? extends T> fn)
 * <U> CompletableFuture<U> handle(BiFunction<? super T,Throwable,? extends U> fn)
 */
public class Demo {
    public static void main(String[] args) {

        //exceptionallyExample();

        handleExample();

    }

    /**
     * possible output:
     *  - CF EXCEPTION
     *  - initial string (supply)
     */
    static void exceptionallyExample(){
        String s = "initial string";

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> s + " (supply)");

        cf.completeExceptionally(new RuntimeException("cf exception"));

        cf.exceptionally(throwable -> throwable.getMessage().toUpperCase())
                .thenAccept(System.out::println)
                .join();
    }

    /**
     * possible output:
     *  - THIS IS EXCEPTION !!!
     *  - handle example (supply) all ok
     */
    static void handleExample(){
        String s = "handle example";

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> s + " (supply)");

        cf.completeExceptionally(new RuntimeException("this is exception !!!"));

        cf.handle((s1, th) -> {
            if(th == null){
                return s1 + " all ok";
            }
            return th.getMessage().toUpperCase();
        })
           .thenAccept(System.out::println)
           .join();
    }
}
