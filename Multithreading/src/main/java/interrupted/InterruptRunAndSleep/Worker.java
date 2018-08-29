package interrupted.InterruptRunAndSleep;

public class Worker extends Thread {
    @Override
    public void run() {
        long count = 1;
        for (int i = 0; i < 1_000_000_000; i++) {
            count += i;
            if (isInterrupted()) {
                System.out.println("worker Interrupted sum = " + count);
                break;
            }
        }

    }
}
