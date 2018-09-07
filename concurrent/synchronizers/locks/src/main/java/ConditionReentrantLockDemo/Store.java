package ConditionReentrantLockDemo;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Store {
    ReentrantLock locker;
    Condition condition;
    int goods;

    public Store() {
        locker = new ReentrantLock();
        condition = locker.newCondition();
    }

    public void put(){

        locker.lock();
            try {
                while (goods >= 3) {
                    System.out.println("\t\tput await");
                    condition.await();
                }
                goods++;
                System.out.println("producer add one entity");
                System.out.println("goods = " + goods);
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                System.out.println("put unlock");
                locker.unlock();
            }
    }

    public void get(){

        locker.lock();
        try {
            while (goods < 1) {
                System.out.println("\t\tget await");
                condition.await();
            }
            goods--;
            System.out.println("supplier remove one entity");
            System.out.println("goods = " + goods);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("get unlock");
            locker.unlock();
        }

    }
}
