package StaticExample;

public class Client extends Thread {
    int val;

    public Client(int val) {
        this.val = val;
    }

    /**
     *
     *          OR
     *
     *   synchronized (Resorce.class) {
     *             Resorce.change(val);
     *         }
     */
    @Override
    public void run() {
            Resorce.change(val);
    }
}
