package SimplSemaphoreDemo;

import java.util.concurrent.Semaphore;

public class Subtractor implements Runnable {
    String name;
    Semaphore semaphore;

    public Subtractor(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
        new Thread(this, name).start();
    }

    @Override
    public void run() {
        System.out.println("Thread " + name + " waits semaphore"  );
        try {
            semaphore.acquire();
            System.out.println("Thread " + name + " acquire semaphore");

            for (int i = 0; i < 5; i++) {
                System.out.println(name + " : shared value - " + Shared.value--);
            }

            //Thread.sleep(500);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread " + name + " release semaphore");

        semaphore.release();

    }
}
