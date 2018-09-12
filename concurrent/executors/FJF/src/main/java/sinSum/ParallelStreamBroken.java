package sinSum;

import java.util.Arrays;
import java.util.concurrent.atomic.DoubleAdder;

public class ParallelStreamBroken {
    public static void main(String[] args) {
        int[] array = Commons.prepareArr();

        /**
         * Broken
         */
        double[] temp = new double[1];

        DoubleAdder adder = new DoubleAdder();

        long l = System.currentTimeMillis();
        Arrays.stream(array)
                .parallel()
                .mapToDouble(Commons::func)
                .forEach(adder::add);
                //.forEach(value -> temp[0] += value);


        System.out.println("time = " + (System.currentTimeMillis() - l));
        //System.out.println("sum = " + temp[0]);
        System.out.println("sum = " + adder.doubleValue());
    }
}
