package ConditionReentrantLockDemo;

public class Supplier implements Runnable {
    Store store;

    public Supplier(Store store) {
        this.store = store;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            store.get();
        }
    }
}
