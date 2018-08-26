package Synchronized.caller;

/**
 * for synchronization we needed add synchronized at declaration "call" methods
 * in Callme class OR made synchronization in Callme instance in "run" method
 * in Caller class
 */
public class Synch {
    public static void main(String[] args) {
        Callme callme = new Callme();

        Caller caller1 = new Caller("welcome", callme);
        Caller caller2 = new Caller("to synchronized", callme);
        Caller caller3 = new Caller("world", callme);

        try {
            caller1.thread.join();
            caller2.thread.join();
            caller3.thread.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
