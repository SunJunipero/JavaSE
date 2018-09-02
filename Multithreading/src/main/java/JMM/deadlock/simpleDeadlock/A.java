package JMM.deadlock.simpleDeadlock;

public class A {
    public synchronized void foo(B b){
        System.out.println(Thread.currentThread().getName() + " A: foo ");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        b.last();

    }

    public synchronized void last(){
        System.out.println(" A: last ");
    }
}
