package SimpleExample;

import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
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



    }
}
