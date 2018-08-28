package waitnotify.QueueConsumerProducer;

public class Q {
    int n;
    boolean val = false;

    synchronized  int getN(){
        while (!val)
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println("Get " + n);
        val = false;
        notify();
        return n;
    }

    synchronized void put(int n){
        while (val) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.n = n;
        val = true;
        System.out.println("put " + n);
        notify();
    }


}
