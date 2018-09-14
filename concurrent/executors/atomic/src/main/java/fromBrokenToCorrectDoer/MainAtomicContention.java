package fromBrokenToCorrectDoer;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainAtomicContention {
    public static void main(String[] args) throws InterruptedException {
        Doer doer = new Doer();
        final int THREADS = Runtime.getRuntime().availableProcessors();
        AtomicInteger count = new AtomicInteger();
        CountDownLatch latch = new CountDownLatch(1);

        Runnable r = ()->{
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            doer.doOnce(count::getAndIncrement);
        };

        List<Thread> threads = Stream.generate(() -> new Thread(r))
                .limit(THREADS)
                .peek(Thread::start)
                .collect(Collectors.toList());

        latch.countDown();

        for (Thread thread : threads) {
            thread.join();
        }

        if(count.get() != 1)
            System.out.println("Doer broken !!!");

        System.out.println("FINISHED");

    }
}
