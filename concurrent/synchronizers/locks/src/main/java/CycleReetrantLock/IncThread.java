package CycleReetrantLock;

public class IncThread implements Runnable{
    Work work;

    public IncThread(Work work) {
        this.work = work;
        new Thread(this, "IncThread").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            work.put();
        }

    }
}
