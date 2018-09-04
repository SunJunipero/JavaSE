package ExchangeCustomObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Consumer extends Thread{
    Exchanger<List<Cargo>> exchanger;
    int quantity = 1;
    List<Cargo> cargos;

    public Consumer(Exchanger<List<Cargo>> exchanger, int quantity) {
        this.exchanger = exchanger;
        this.quantity = quantity;
    }

    @Override
    public void run() {
        for (int i = 0; i < quantity; i++) {
            try {
                cargos = exchanger.exchange(new ArrayList<>());
                System.out.println("\t\t new cargo");
                System.out.println(cargos);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
