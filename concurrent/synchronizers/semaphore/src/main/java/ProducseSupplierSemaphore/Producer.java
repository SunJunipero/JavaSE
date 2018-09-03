package ProducseSupplierSemaphore;

public class Producer implements Runnable{
    Q q;

    Producer(Q q){
        this.q = q;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            q.put(i);
        }
    }
}
