package ConditionReentrantLockDemo;

public class Producer implements Runnable {
    Store store;


    public Producer(Store store) {
        this.store = store;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            store.put();
        }
    }
}
