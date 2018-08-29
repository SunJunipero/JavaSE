package interrupted.InterruptRunAndSleep;

public class Sleeper extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Sleeper is interrupted");
        }
    }
}
