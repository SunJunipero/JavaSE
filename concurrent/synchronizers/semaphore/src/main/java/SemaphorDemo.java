import java.util.concurrent.Semaphore;

public class SemaphorDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(0);

        semaphore.release(); // +1
        semaphore.release(); // +1

        /**
         * availablePermits - 2
         */
        System.out.println(semaphore.availablePermits());


    }
}
