package waitnotify.repeat;

public class Consumer implements Runnable {

    private Text text;

    public Consumer(Text text) {
        this.text = text;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("from consumer : " + name + " waited");
        synchronized (text){
            try {
                text.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("the end " + Thread.currentThread().getName());
        System.out.println(" ---> from consumer : " + text.getText());
    }
}
