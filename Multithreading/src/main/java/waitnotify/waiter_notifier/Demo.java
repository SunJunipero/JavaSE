package waitnotify.waiter_notifier;

public class Demo {
    public static void main(String[] args) {
        Message message = new Message("message");

        Waiter waiter1 = new Waiter(message);
        Waiter waiter2 = new Waiter(message);


        Thread thread1 = new Thread(waiter1, "waiter1");
        thread1.start();
        Thread thread2 = new Thread(waiter2, "waiter2");
        thread2.start();

        Notifier notifier = new Notifier(message);
        Thread notifier_thread = new Thread(notifier, "notifier");
        notifier_thread.start();




        System.out.println("started ...");

        try {
            System.out.println("state - " + notifier_thread.getState());
            System.out.println("state - " + thread1.getState());
            System.out.println("state - " + thread2.getState());
            thread1.join();
            thread2.join();
            notifier_thread.join();
            System.out.println("state - " + notifier_thread.getState());
            System.out.println("state - " + thread1.getState());
            System.out.println("state - " + thread2.getState());


        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
