package CreateThread;

public class ExtendThreadDemo {
    public static void main(String[] args) {
        new NewThread();


        try {
            for (int i = 0; i <= 5 ; i++) {
                System.out.println("i - " + i);
                System.out.println("from " + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " stopped");





    }
}
