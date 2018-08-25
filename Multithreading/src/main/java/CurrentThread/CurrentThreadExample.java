package CurrentThread;

public class CurrentThreadExample {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();

        System.out.println("Current name - " + thread.getName());

        thread.setName("Main thread");

        System.out.println("Current name - " + thread.getName());

        for (int i = 0; i <=5 ; i++) {
            System.out.println("i = " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
