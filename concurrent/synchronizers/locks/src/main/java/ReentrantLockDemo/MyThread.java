package ReentrantLockDemo;

import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread {
    ReentrantLock lock;

    public MyThread(ReentrantLock lock) {
        this.lock = lock;
        start();
    }

    @Override
    public void run() {
        lock.lock();
        System.out.println(getName() + " started " );
        try {
            System.out.println(getName() + " await lock " );
            System.out.println(getName() + " block count" );
            SharedClass.inc++;
            System.out.println(getName() + " count = " + SharedClass.inc );
            System.out.println(getName() + " await " );
            /**
             * change context, if it possible
             */
            sleep(500);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            System.out.println(getName() + " unlock " );
            lock.unlock();
        }
    }
}
