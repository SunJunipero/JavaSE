package interrupted.Example1;

public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("in my thread");
        } catch (InterruptedException e) {
            System.out.println("Exception handled" +  e);
        }
        System.out.println("Still working");
    }
}
