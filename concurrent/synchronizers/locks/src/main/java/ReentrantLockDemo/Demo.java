package ReentrantLockDemo;

import java.util.concurrent.locks.ReentrantLock;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        new MyThread(lock);
        new MyThread(lock);

        Thread.sleep(1500);

        System.out.println("FINISHED");

    }
}
