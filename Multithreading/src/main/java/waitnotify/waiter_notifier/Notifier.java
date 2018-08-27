package waitnotify.waiter_notifier;

public class Notifier implements Runnable {

    private Message msg;

    public Notifier (Message msg){
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " started");
       // try {
            //Thread.sleep(1000);
            synchronized (msg){
                msg.setMsg(name + " thread Notifier is completed");
               // msg.notify();
                msg.notifyAll();
            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}
