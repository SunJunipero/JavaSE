package UsingCF.AsyncReading.AllOf;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(10, 12, 6, 9, 5, 15, 20);

        List<CompletableFuture<BigInteger>> futures = integers.stream()
                .map(integer -> CompletableFuture.supplyAsync(() -> fac(integer)))
                .collect(Collectors.toList());

        /**
         * Note the difference between output of anyOf and allOf (???)
         *
         *          all0f
         * 3628800
         * 479001600
         * 720
         * 362880
         * 120
         * 1307674368000
         * 2432902008176640000
         *
         *          anyOf
         * 1
         * 1
         * 1
         * 1
         * 1
         * 1
         * 1
         *
         * //////
         *
         * 1
         * 479001600
         * 720
         * 362880
         * 120
         * 1307674368000
         * 2432902008176640000
         *
         */

        //CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
        CompletableFuture.anyOf(futures.toArray(new CompletableFuture[futures.size()]));

        futures.forEach(cf -> System.out.println(cf.getNow(BigInteger.ONE)));
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
