
public class Demo {
    public static void main(String[] args) {
        System.out.println("available Processors - " + Runtime.getRuntime().availableProcessors());

        Thread thread = new Thread(){
            public void run(){
                System.out.println(Thread.currentThread().getName() + " started");
            }
        };

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName());


    }


}
