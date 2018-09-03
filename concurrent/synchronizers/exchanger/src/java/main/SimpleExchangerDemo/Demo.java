package SimpleExchangerDemo;

import java.util.concurrent.Exchanger;

public class Demo {
    public static void main(String[] args) {
        Exchanger<String> stringExchanger = new Exchanger<>();
        new Producer(stringExchanger).start();
        new Consumer(stringExchanger).start();
    }
}
