package SequenceAtomicGoodInc;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo {
    private static AtomicInteger count = new AtomicInteger();

    private static int nextInt(){
        return count.getAndIncrement();
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
