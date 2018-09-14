package fromBrokenToCorrectDoer;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainContention {
    public static void main(String[] args) throws InterruptedException {
        //final int THREADS = 300;
        final int THREADS = Runtime.getRuntime().availableProcessors();

        Doer doer = new Doer();

        CountDownLatch latch = new CountDownLatch(1);

        Runnable r = ()->{
            doer.doOnce(()->{
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("In thread " + Thread.currentThread().getName());
            });
        };

        List<Thread> threads = Stream.generate(() -> new Thread(r))
                .limit(THREADS)
                .peek(Thread::start)
                .collect(Collectors.toList());

        latch.countDown();

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("FINISHED");


    }
}
