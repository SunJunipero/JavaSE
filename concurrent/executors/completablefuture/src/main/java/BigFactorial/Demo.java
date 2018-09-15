package BigFactorial;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Demo {
    private static BigInteger factorial(int n){
        BigInteger res = BigInteger.ONE;
        while (n > 1){
            res = res.multiply(BigInteger.valueOf(n));
            n--;
        }
        return res;
    }

    private static BigInteger combination (int n, int k ){
        return factorial(n).divide(factorial(k)).divide(factorial(n - k));
    }

    public static void main(String[] args) {
//        IntStream.range(1, 10)
//                .boxed()
//                .map(Demo::factorial)
//                .forEach(System.out::println);

        for (int i = 0; i < 10; i++) {
            long l = System.currentTimeMillis();
            BigInteger combination = combination(10_000, 2_000);
            System.out.println(i + " time = " + (System.currentTimeMillis() - l));
        }
        /**
         * -Completable Future
         * 0 time = 322
         * 1 time = 132
         * 2 time = 123
         * 3 time = 139
         * 4 time = 149
         * 5 time = 104
         * 6 time = 99
         * 7 time = 92
         * 8 time = 84
         * 9 time = 108
         */



    }
}
