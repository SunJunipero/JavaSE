package AtomicReference.broken;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BrokenDemo {
    public static void main(String[] args) throws InterruptedException {
        BrokeAtomicPoint point = new BrokeAtomicPoint();

        List<MyThread> threads = Stream.generate(() -> new MyThread(point))
                .limit(10)
                .peek(MyThread::start)
                .collect(Collectors.toList());


        for (MyThread thread : threads) {
            thread.join();
        }

        System.out.println("FINISHED");
    }
}
