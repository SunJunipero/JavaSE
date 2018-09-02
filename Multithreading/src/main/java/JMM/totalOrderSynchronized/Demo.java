package JMM.totalOrderSynchronized;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Data data = new Data();

        Thread thread1 = new Thread(()->{
            data.modifyX();
        });

        Thread thread2 = new Thread(()->{
            data.modifyX();
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("x = " + data.x);

    }
}
