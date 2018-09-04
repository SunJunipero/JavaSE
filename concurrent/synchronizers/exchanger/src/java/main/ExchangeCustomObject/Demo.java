package ExchangeCustomObject;

import java.util.List;
import java.util.concurrent.Exchanger;

public class Demo {
    public static void main(String[] args) {

        Exchanger<List<Cargo>> exchanger = new Exchanger<>();

        Producer producer = new Producer(exchanger, 3);
        Consumer consumer = new Consumer(exchanger, 3);

        producer.start();
        consumer.start();

    }
}
