import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * latch can not to be negative, only equals zero
 */

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(4);

        new TestThread(countDownLatch).start();

        countDownLatch.await();

        System.out.println("Thread finished");
    }

    static class TestThread extends Thread{
        CountDownLatch latch;

        public TestThread(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                System.out.println("latch - " + latch.getCount());
                latch.countDown();
            }
        }
    }
}
