package CycleReetrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Work {
    ReentrantLock locker;
    Condition condition;
    int count;

    public Work() {
        locker = new ReentrantLock();
        condition = locker.newCondition();
    }

    void get(){
        locker.lock();
        try {
            while (count < 1)
                condition.await();
            count--;
            System.out.println(Thread.currentThread().getName() + "  count = " + count);
            condition.signalAll();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        finally {
            locker.unlock();
        }
    }

    void put(){
        locker.lock();
        try {
            while (count >= 1)
                condition.await();
            count++;
            System.out.println(Thread.currentThread().getName() + "  count = " + count);
            condition.signalAll();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        finally {
            locker.unlock();
        }
    }
}
