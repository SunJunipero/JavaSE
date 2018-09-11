package recursiveaction;

import java.util.concurrent.ForkJoinPool;

/**
 * 10_000
 *  time - 86698205
 *  time - 6457760
 *  time - 19963706
 *  time - 7798589
 *  time - 7658888
 *  time - 19439348
 *  time - 22077626
 * 100_000
 *  time - 20019958
 *  time - 21141741
 *  time - 33341636
 *  time - 17939108
 *  time - 58841153
 * 1_000_000
 *  time - 59544245
 *  time - 40790340
 *
 *
 *
 */
public class Demo {
    public static void main(String[] args) {
        double [] initArr = new double[1_000_000];

        for (int i = 0; i < initArr.length; i++) {
            initArr[i] = i;
        }

//        for (int i = 0; i < 30; i++) {
//            System.out.print(initArr[i] + " ");
//        }

//        ForkJoinPool fjp = new ForkJoinPool();
//
//        System.out.println("parallelism level " + fjp.getParallelism());
//
//        MyAction myAction = new MyAction(initArr, 0, initArr.length);

        long l = System.nanoTime();
        //fjp.invoke(myAction);
        new SequentialAction(initArr, 0, initArr.length).sqrtTransform();
        //System.out.println("time - " + (System.nanoTime() - l));

//        for (int i = 0; i < 30; i++) {
//            System.out.print(initArr[i] + " ");
//        }
    }
}

