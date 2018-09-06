package SequenceIncBroken;

import java.util.ArrayList;

/**
 * volatile guarantees only atomic writing and reading (not increment)
 * And expected result will not be equal to 1000
 * how fix it -
 *  1) make private static synchronized int nextInt
 *
 *  2)  private static AtomicInteger count = new AtomicInteger();
 *      private static int nextInt(){
 *         return count.getAndIncrement();
 *     }
 *
 */
public class Demo {
    private static volatile int count;

    private static  int nextInt(){
        return count++;
    }

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 1_0; i++) {
           Thread t =  new Thread(()->{
                for (int j = 0; j < 1_000; j++) {
                    nextInt();
                }
            });
           t.start();
           threads.add(t);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("count - " + count);

    }
}
