package interrupted.Example;

public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("in my thread");
        } catch (InterruptedException e) {
            throw new RuntimeException("thread interrupted looool");
        }
    }
}
