package JMM.deadlock.simpleDeadlock.deadlockSolution;

import java.util.concurrent.locks.ReentrantLock;

public class A {
    ReentrantLock lock;

    public A(ReentrantLock lock) {
        this.lock = lock;
    }
    public  void foo(B b){
        System.out.println(Thread.currentThread().getName() + " A: foo ");
        try {
         //   lock.lock();
            SharedClass.count++;
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
         //   lock.unlock();
        }

        b.last();

    }

    public synchronized void last(){
        System.out.println(" A: last ");
    }
}
