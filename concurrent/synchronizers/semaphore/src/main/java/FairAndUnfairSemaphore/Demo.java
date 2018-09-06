package FairAndUnfairSemaphore;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 *
 *      UNFAIR RUN
 *
 * Thread-0acquire semaphore
 * Thread-1acquire semaphore
 * Thread-0release semaphore
 * Thread-0acquire semaphore
 * Thread-1release semaphore
 * Thread-1acquire semaphore
 * Thread-0release semaphore
 * Thread-0acquire semaphore
 * Thread-1release semaphore
 * Thread-1acquire semaphore
 * Thread-0release semaphore
 * Thread-0acquire semaphore
 * Thread-1release semaphore
 * Thread-1acquire semaphore
 * Thread-0release semaphore
 * Thread-0acquire semaphore
 * Thread-1release semaphore
 * Thread-1acquire semaphore
 * FINISHED
 * Thread-5interrupted
 * Thread-3interrupted
 * Thread-6interrupted
 * Thread-1release semaphore
 * Thread-0release semaphore
 * Thread-1interrupted
 * Thread-8interrupted
 * Thread-9interrupted
 * Thread-7interrupted
 * Thread-4interrupted
 * Thread-2interrupted
 * Thread-0interrupted
 *
 *             FAIR RUN
 *
 *             Thread-0acquire semaphore
 * Thread-1acquire semaphore
 * Thread-0release semaphore
 * Thread-1release semaphore
 * Thread-2acquire semaphore
 * Thread-3acquire semaphore
 * Thread-2release semaphore
 * Thread-3release semaphore
 * Thread-4acquire semaphore
 * Thread-5acquire semaphore
 * Thread-4release semaphore
 * Thread-5release semaphore
 * Thread-6acquire semaphore
 * Thread-7acquire semaphore
 * Thread-6release semaphore
 * Thread-7release semaphore
 * Thread-9acquire semaphore
 * Thread-8acquire semaphore
 * FINISHED
 * Thread-3interrupted
 * Thread-8release semaphore
 * Thread-4interrupted
 * Thread-0interrupted
 * Thread-1interrupted
 * Thread-2interrupted
 * Thread-7interrupted
 * Thread-8interrupted
 * Thread-9release semaphore
 * Thread-6interrupted
 * Thread-5interrupted
 * Thread-9interrupted
 */

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(2, true);

        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            MyThread t = new MyThread(semaphore);
            t.start();
            threads.add(t);
        }

        Thread.sleep(20_000);

        for (Thread thread : threads) {
            thread.interrupt();
        }


        System.out.println("FINISHED");

    }

    static class MyThread extends Thread{
        Semaphore semaphore;

        public MyThread(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                routin();
            }
            catch (InterruptedException e){
                System.out.println(getName() + "interrupted");
            }
        }

        public void routin() throws InterruptedException {
         for(;;){
             semaphore.acquire();
             try {
                 System.out.println(getName() + "acquire semaphore");
                 sleep(5000);
             }
             finally {
                 System.out.println(getName() + "release semaphore");
                 semaphore.release();
             }
         }
        }
    }
}
