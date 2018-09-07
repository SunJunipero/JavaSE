package CycleReetrantLock;

public class DecThread implements Runnable {
    Work work;

    public DecThread(Work work) {
        this.work = work;
        new Thread(this, "DecThread").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            work.get();
        }

    }
}
