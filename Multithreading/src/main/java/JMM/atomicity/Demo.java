package JMM.atomicity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    static  class Count{
         int x = 0;
    }

    static Count count = new Count();

    static Runnable r = () -> {
        for (int i = 0; i < 1_000_000; i++) {
            /**
             *      GOOD
             * synchronized (count) {
             *                 count.x++;
             *             }
             */
                count.x++;
        }
    };

//     Runnable r1 = new Runnable() {
//        @Override
//        public synchronized void run() {
//            for (int i = 0; i < 1_000_000; i++) {
//                count.x ++;
//        }
//    }

    public static void main(String[] args) throws InterruptedException {
            List<Thread> collect = Stream.generate(() -> new Thread(r))
                    .limit(10).peek(Thread::start)
                    .collect(Collectors.toList());

            for (Thread thread : collect) {
                thread.join();
            }

            System.out.println("res - " + count.x);

        }
}
