package SimpleExchangerDemo;

import java.util.concurrent.Exchanger;

public class Producer extends Thread {
    private Exchanger<String> exchanger;
    private String msg = "";

    public Producer(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        System.out.println("new");
    }

    @Override
    public void run() {
        char seed = 'A';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                msg += (char)seed++;
            }
            try {
                msg = exchanger.exchange(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
