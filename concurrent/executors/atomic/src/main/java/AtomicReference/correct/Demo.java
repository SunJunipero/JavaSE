package AtomicReference.correct;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        AtomicPoint point = new AtomicPoint();

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
