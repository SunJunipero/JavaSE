package CreateThread;

public class NewThread extends Thread{
    NewThread(){
        super("new thread");
        start();

    }
    @Override
    public void run() {
        try {
            for (int i = 0; i <= 5; i++) {
                System.out.println("i - " + i);
                System.out.println("from - " + this.getName());
                Thread.sleep(500);
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(this.getName() + " stopped");

    }
}

