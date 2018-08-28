package waitnotify.store;

public class Demo {
    public static void main(String[] args) {
        Store store=new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        Thread pr_thread = new Thread(producer, "producer");
        Thread cr_thread = new Thread(consumer, "consumer");
        pr_thread.start();
        cr_thread.start();
    }
}
