package SharedLatch;

import java.util.concurrent.CountDownLatch;

public class MyThread extends Thread{
    private CountDownLatch latch;

    public MyThread() {
    }

    public MyThread(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            sleep((long) (Math.random() * 10_000));
            System.out.println(getName() + " await latch");
            latch.countDown();
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + "Finished");
    }
}
