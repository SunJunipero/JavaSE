package interrupted.Example2;

/**
 * if we commented Thread.sleep(1000)
 * then method completely running
 *
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                System.out.println(i + " : Interrupted -  " + Thread.interrupted()
                        + " status - " + Thread.currentThread().getState()) ;
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
            System.out.println("Interrupted -  " + Thread.interrupted()
                    + " status - " + Thread.currentThread().getState());
        }


    }
}
