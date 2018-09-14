package fromBrokenToCorrectDoer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainWithoutContention {
    public static void main(String[] args) throws InterruptedException {
        Doer doer = new Doer();

        final int THREADS = Runtime.getRuntime().availableProcessors();

        Runnable r = ()->{
            doer.doOnce(()-> System.out.println("in thread " + Thread.currentThread().getName()));
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
