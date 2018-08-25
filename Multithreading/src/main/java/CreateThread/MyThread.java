package CreateThread;

public class MyThread implements Runnable {
    Thread t;

    MyThread(){
        t = new Thread(this, "MyThread");
        System.out.println(t.getName() + " start" );
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i <= 5; i++) {
                System.out.println("from " + t.getName());
                System.out.println("i -  " + i);
                Thread.sleep(500);
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(t.getName() + " stopped");
    }
}
