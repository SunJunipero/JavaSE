package SequenceAtomicGoodInc;

import java.util.ArrayList;

public class SyncDemo {
    private static volatile int count;

    private static synchronized void incCount(){
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 1_00; i++) {
            Thread t = new Thread(()->{
                for (int j = 0; j < 1_000; j++) {
                    incCount();
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
