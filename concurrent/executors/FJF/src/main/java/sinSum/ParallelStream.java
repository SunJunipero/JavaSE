package sinSum;

import java.util.Arrays;

public class ParallelStream {
    public static void main(String[] args) {
        int[] array = Commons.prepareArr();

        long l = System.currentTimeMillis();
        double sum = Arrays.stream(array)
                .parallel()
                .mapToDouble(Commons::func)
                .sum();

        System.out.println("time = " + (System.currentTimeMillis() - l));
        System.out.println("sum = " + sum);

    }
}
