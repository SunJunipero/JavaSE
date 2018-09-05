package SimpleExample;

import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, ()->{
            System.out.println("barrier achieved");
        });

        MyThread thread1 = new MyThread("thread1", cyclicBarrier);
        MyThread thread2 = new MyThread("thread2", cyclicBarrier);
        MyThread thread3 = new MyThread("thread3", cyclicBarrier);

        List<MyThread> collect = Stream.of(thread1, thread2, thread3)
                .peek(MyThread::start)
                .collect(Collectors.toList());

        collect.forEach(myThread -> {
            try {
                myThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        /*
        Use barrier again
         */
        Thread.sleep(100);

        MyThread thread4 = new MyThread("thread4", cyclicBarrier);
        MyThread thread5 = new MyThread("thread5", cyclicBarrier);
        MyThread thread6 = new MyThread("thread6", cyclicBarrier);

        List<MyThread> collect1 = Stream.of(thread4, thread5, thread6)
                .peek(MyThread::start)
                .collect(Collectors.toList());

        collect.forEach(myThread -> {
            try {
                myThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });





    }
}
