package FixedThreadPool;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

public class MyThread extends Thread{
    private CountDownLatch latch;
    private String name;

    public MyThread(CountDownLatch latch, String name) {
        this.latch = latch;
        this.name = name;
    }

    @Override
    public void run() {
        IntStream.rangeClosed(1, 5)
                .boxed()
                .forEach(integer -> {
                    System.out.println(name + " : counter -  " + integer);
                    latch.countDown();
                //    System.out.println("latch - "  + latch.getCount());
                });
    }
}
