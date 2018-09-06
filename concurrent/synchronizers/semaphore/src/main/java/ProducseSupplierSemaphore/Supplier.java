package ProducseSupplierSemaphore;

public class Supplier implements Runnable{
    Q q;

    public Supplier(Q q) {
        this.q = q;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            q.get();
        }
    }
}
