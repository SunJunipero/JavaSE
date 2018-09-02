package JMM.deadlock.simpleDeadlock;

public class B {
    public synchronized void baz(A a){
        System.out.println(Thread.currentThread().getName() + " B: baz ");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        a.last();

    }

    public synchronized void last(){
        System.out.println(" B: last ");
    }
}
