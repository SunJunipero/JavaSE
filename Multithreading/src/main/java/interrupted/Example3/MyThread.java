package interrupted.Example3;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("initial state - " + this.isInterrupted());
        for (int i = 0; i < 5; i++) {
            if(Thread.interrupted()){
                System.out.println(Thread.currentThread().getName() + " is interrupted ");
                System.out.println("isInterrupted - " + this.isInterrupted());
                //return;
            }
            else{
                System.out.println(Thread.currentThread().getName() + " is working ");
                System.out.println("isInterrupted - " + this.isInterrupted());
            }
        }
    }
}
