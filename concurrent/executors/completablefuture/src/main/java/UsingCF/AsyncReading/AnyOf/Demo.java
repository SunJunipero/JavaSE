package UsingCF.AsyncReading.AnyOf;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * 15 - 1.307.674.368.000
 * 10 - 3.628.800
 * 20 - 2.432.902.008.176.640.000
 *
 * 1_307_674_368_000
 */
public class Demo {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(15, 10, 20);

        List<CompletableFuture<BigInteger>> futures = integers.stream()
                .map(integer -> CompletableFuture.supplyAsync(() -> fact(integer)))
                .collect(Collectors.toList());

       CompletableFuture.anyOf(futures.toArray(new CompletableFuture[futures.size()]))
               .whenComplete((o, throwable) -> {
                   if(throwable == null)
                       System.out.println("res = " + o);
               });
    }

    static BigInteger fact(int n){
        BigInteger res = BigInteger.ONE;
        while (n > 1){
            res = res.multiply(BigInteger.valueOf(n));
            n--;
        }
        return res;
    }
}
