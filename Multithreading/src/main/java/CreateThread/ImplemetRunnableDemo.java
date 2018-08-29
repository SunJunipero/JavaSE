package CreateThread;

public class ImplemetRunnableDemo {
    public static void main(String[] args) {
            new MyThread();


        Thread thread = Thread.currentThread();
        try {
                for (int i = 0; i <= 5; i++) {
                    System.out.println("from " + thread.getName());
                    System.out.println("i - " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println(thread.getName() + " stopped");
        }
    }
