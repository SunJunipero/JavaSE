package SimpleCountDownLatchDemo;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);

        MyThread myThread = new MyThread(latch, 3, "Thread1");
        MyThread myThread1 = new MyThread(latch, 5,"Thread2");
        MyThread myThread2 = new MyThread(latch, 7,"Thread3");
        MyThread myThread3 = new MyThread(latch, 6,"Thread4");
        MyThread myThread4 = new MyThread(latch, 2,"Thread5"); // = 23

        List<MyThread> collect = Stream.of(myThread, myThread1, myThread2, myThread3, myThread4)
                .peek(MyThread::start)
                .collect(Collectors.toList());


        latch.await();

        Thread.sleep(200);

        System.out.println("result val - " + Shared.value);


        System.out.println("count - " + latch.getCount());

        MyThread myThread5 = new MyThread(latch, 6, "Thread6");
        MyThread myThread6 = new MyThread(latch, 6,"Thread7");
        MyThread myThread7 = new MyThread(latch, 6,"Thread8");
        MyThread myThread8 = new MyThread(latch, 7,"Thread9");
        MyThread myThread9 = new MyThread(latch, 8,"Thread10"); // = 23

        List<MyThread> collect1 = Stream.of(myThread5, myThread6, myThread7, myThread8, myThread9)
                .peek(MyThread::start)
                .collect(Collectors.toList());

        latch.await();

       // Thread.sleep(200);

        System.out.println(" 2 ) result val - " + Shared.value);





    }
}
