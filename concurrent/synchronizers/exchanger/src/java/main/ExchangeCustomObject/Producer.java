package ExchangeCustomObject;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Producer extends Thread{
    Exchanger<List<Cargo>> exchanger;
    List<Cargo> cargos;
    int quantiy = 1;

    public Producer(Exchanger<List<Cargo>> exchanger, int quantiy) {
        this.exchanger = exchanger;
        this.quantiy = quantiy;
    }

    @Override
    public void run() {

        for (int i = 0; i < quantiy; i++) {
            cargos = Stream.generate(Cargo::new).limit(10)
                    .peek(cargo -> {
                        int id = new Random().nextInt(20);
                        cargo.setId(id);
                        cargo.setLabel("Label" + id);
                    })
                    .collect(Collectors.toList());

            try {
                cargos = exchanger.exchange(cargos);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
