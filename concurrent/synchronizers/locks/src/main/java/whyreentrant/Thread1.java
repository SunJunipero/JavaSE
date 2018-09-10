package whyreentrant;

import java.util.concurrent.locks.ReentrantLock;

public class Thread1 extends Thread {
    ReentrantLock lock;

    public Thread1(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println(getName() + " started " );
        lock.lock();
        System.out.println(getName() + " 1st lock " );
        try {
            SharedClass.counter += 5;
            System.out.println("counter = " + SharedClass.counter);
            System.out.println(getName() + " sleeping ");
            sleep(500);
            lock.lock();
            System.out.println(getName() + " 2nd lock " );
            try {
                SharedClass.counter += 10;
                System.out.println("counter = " + SharedClass.counter);
                System.out.println(getName() + " sleeping ");
                sleep(500);
            }
            finally {
                System.out.println(getName() + " 2nd unlock " );
                lock.unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(getName() + " 1st unlock " );
            lock.unlock();
        }
    }
}
