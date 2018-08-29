package interrupted.Example;

/**
 * interrupting a thread that stops working
 */
public class Demo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        myThread.start();

        try {
            myThread.interrupt();
        }
        catch (Exception r){
            System.out.println("Exception handled !!!- " + r);
        }

    }
}
