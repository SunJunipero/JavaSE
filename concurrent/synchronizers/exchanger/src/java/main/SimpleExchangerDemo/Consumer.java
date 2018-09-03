package SimpleExchangerDemo;

import java.util.concurrent.Exchanger;

public class Consumer extends Thread {
    Exchanger<String> exchanger;
    String str;

    public Consumer(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                str = exchanger.exchange("");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("get str - " + str);
        }
    }
}
