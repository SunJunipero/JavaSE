package ProducseSupplierSemaphore;

import java.util.concurrent.Semaphore;

public class Q {
    int n;

    static Semaphore prodSemaphore = new Semaphore(1);
    static Semaphore suppSemaphore = new Semaphore(0);

    public void get(){
        System.out.println("supplier waits suppSemaphore");
        try {
            suppSemaphore.acquire();
            System.out.println("supplier acquire suppSemaphore");
            System.out.println("value n = " + n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("supplier release prodSemaphore");
        prodSemaphore.release();
    }

    public void put(int i){
        System.out.println("producer waits prodSemaphore");

        try {
            prodSemaphore.acquire();
            System.out.println("producer acquire prodSemaphore");
            n = i;
            System.out.println("send -  " + i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("producer release suppSemaphore");
        suppSemaphore.release();
    }
}
