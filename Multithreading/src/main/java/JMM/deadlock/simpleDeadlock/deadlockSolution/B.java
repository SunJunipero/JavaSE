package JMM.deadlock.simpleDeadlock.deadlockSolution;

import java.util.concurrent.locks.ReentrantLock;

public class B {
    ReentrantLock lock;

    public B(ReentrantLock lock) {
        this.lock = lock;
    }

    public  void baz(A a){
        System.out.println(Thread.currentThread().getName() + " B: baz ");

        try {
       //     lock.lock();
            SharedClass.count++;
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
      //      lock.unlock();
        }
        a.last();

    }

    public synchronized void last(){
        System.out.println(" B: last ");
    }
}
