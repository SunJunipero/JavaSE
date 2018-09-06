package SharedLatch;

import java.util.concurrent.CountDownLatch;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(10);

        Stream.generate(() -> new MyThread(latch)).limit(10)
                .forEach(MyThread::start);

    }
}
