package BigFactorial;

import java.math.BigInteger;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

    private static BigInteger factorial(int n){
        BigInteger res = BigInteger.ONE;
        while (n > 1){
            res = res.multiply(BigInteger.valueOf(n));
            n--;
        }
        return res;
    }

    private static BigInteger combination (int n, int k ){
        CompletableFuture<BigInteger> Nfac = CompletableFuture.supplyAsync(()->factorial(n));
        CompletableFuture<BigInteger> Kfac = CompletableFuture.supplyAsync(()->factorial(k));
        CompletableFuture<BigInteger> NdecKfac = CompletableFuture.supplyAsync(()->factorial(n-k));

        return Nfac.thenCombine(Kfac, BigInteger::divide)
                .thenCombine(NdecKfac, BigInteger::divide)
                .join();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            long l = System.currentTimeMillis();
            BigInteger combination = combination(10_000, 2_000);
            System.out.println(i + " time = " + (System.currentTimeMillis() - l));
        }
    }
    /**
     * --Sequential
     *
     * 0 time = 1158
     * 1 time = 856
     * 2 time = 623
     * 3 time = 1059
     * 4 time = 485
     * 5 time = 472
     * 6 time = 937
     * 7 time = 457
     * 8 time = 473
     * 9 time = 444
     */
}
