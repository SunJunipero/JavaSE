package whyreentrant;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock locker = new ReentrantLock();
        Thread1 thread1 = new Thread1(locker);
        Thread1 thread2 = new Thread1(locker);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


        System.out.println("\t\tcounter = " + SharedClass.counter);

    }
}
