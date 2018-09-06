package JMM.deadlock.simpleDeadlock;

import java.util.concurrent.locks.Lock;

public class Demo {
    static A a = new A();
    static B b = new B();

    static Thread thread1 = new Thread(()->{
        a.foo(b);
    },"thread1");
    static Thread thread2 = new Thread(()->{
        b.baz(a);
    },"thread2");

    public static void main(String[] args) {

        thread1.start();
        thread2.start();
    }
}
