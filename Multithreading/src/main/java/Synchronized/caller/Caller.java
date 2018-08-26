package Synchronized.caller;

public class Caller implements Runnable{
    String msg;
    Callme target;
    Thread thread;

    Caller(String msg, Callme target){
        this.msg = msg;
        this.target = target;
        thread = new Thread(this);
        thread.start();

    }

    @Override
    public void run() {
        synchronized (target) {
            target.call(msg);
        }
    }
}
