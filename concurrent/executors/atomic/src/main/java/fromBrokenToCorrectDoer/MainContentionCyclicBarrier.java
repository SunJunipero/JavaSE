package fromBrokenToCorrectDoer;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainContentionCyclicBarrier {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger count = new AtomicInteger();
        /**
         * Broken Doer
         */
        //AtomicReference<Doer> doer = new AtomicReference<>();
        /**
         * Correct Doer
         */
        AtomicReference<SyncDoer> doer = new AtomicReference<>();
        final int THREADS = Runtime.getRuntime().availableProcessors();
        final int JUMPS = 1_000;

        CyclicBarrier barrier = new CyclicBarrier(THREADS, ()-> {
           // System.out.println("after : count = " + count.get());
            if (count.get() > 1){
                System.out.println("Doer broken !!!");
                }
            //doer.set(new Doer());
            doer.set(new SyncDoer());
            count.set(0);
        });

        Runnable r = ()->{
            for (int i = 0; i < JUMPS; i++) {
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                doer.get().doOnce(count::incrementAndGet);
                //System.out.println("Jump " + i + " " + count.get() + "  " + Thread.currentThread().getName());
            }
        };

        List<Thread> threads = Stream.generate(() -> new Thread(r))
                .limit(THREADS)
                .peek(Thread::start)
                .collect(Collectors.toList());

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("FINISHED");

    }
}
