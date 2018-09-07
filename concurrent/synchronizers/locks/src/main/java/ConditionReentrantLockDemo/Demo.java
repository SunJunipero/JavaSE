package ConditionReentrantLockDemo;

public class Demo {
    public static void main(String[] args) {
        Store store = new Store();
        new Supplier(store);
        new Producer(store);



    }
}
