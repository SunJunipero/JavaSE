package repeat;

public class Supplier implements Runnable{

    private Text text;

    public Supplier(Text text) {
        this.text = text;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " started");
        synchronized (text){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            text.setText(name + " : from supplier with love");
            text.notifyAll();
        }
    }
}
