package waitnotify.waiter_notifier;

public class Waiter implements Runnable {

    private Message msg;

    public Waiter (Message msg){
        this.msg = msg;
    }
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (msg){
            try {
                System.out.println(name + " wait for notify " + System.currentTimeMillis());
                msg.wait();
                System.out.println("after notify");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " notify was called " + System.currentTimeMillis());
        System.out.println(name + " : " + msg.getMsg());


    }
}
