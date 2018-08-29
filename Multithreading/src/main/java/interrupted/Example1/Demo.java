package interrupted.Example1;

/**
 * interrupting a thread that doesn't stop working
 */
public class Demo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        myThread.start();

        myThread.interrupt();


    }
}
