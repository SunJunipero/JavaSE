package JMM.deadlock.simpleDeadlock.deadlockSolution;

import java.util.concurrent.locks.ReentrantLock;

public class Demo {
    static ReentrantLock lock = new ReentrantLock();
    static A a = new A(lock);
    static B b = new B(lock);

    static Thread thread1 = new Thread(()->{
        a.foo(b);
    },"thread1");
    static Thread thread2 = new Thread(()->{
        b.baz(a);
    },"thread2");

    public static void main(String[] args) throws InterruptedException {



        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("count = " + SharedClass.count);
    }
}
