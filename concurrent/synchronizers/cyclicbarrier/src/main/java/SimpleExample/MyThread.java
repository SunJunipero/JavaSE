package SimpleExample;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyThread extends Thread {
    String name;
    CyclicBarrier barrier;

    public MyThread(String name, CyclicBarrier barrier) {
        this.name = name;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " : before barrier");
            System.out.println(name + " : NumberWaiting - " + barrier.getNumberWaiting());
            barrier.await();
            System.out.println(name + " : after barrier");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
