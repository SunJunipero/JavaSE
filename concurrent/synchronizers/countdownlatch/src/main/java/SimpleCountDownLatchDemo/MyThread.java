package SimpleCountDownLatchDemo;

import java.util.concurrent.CountDownLatch;

public class MyThread extends Thread {
    CountDownLatch latch;
    int incVal;
    String name;

    public MyThread(CountDownLatch latch, int incVal, String name) {
        this.latch = latch;
        this.incVal = incVal;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < incVal; i++) {
            Shared.value++;
        }
        latch.countDown();
        System.out.println( name + " : count latch - " + latch.getCount());
    }
}
