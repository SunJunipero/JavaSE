
package CarWash;

import java.util.concurrent.Phaser;

public class CarWasher extends Thread{
    private String name;
    private Phaser phaser;

    public CarWasher(String name, Phaser phaser) {
        this.name = name;
        this.phaser = phaser;
        start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(name + " washes car ");
            phaser.arriveAndAwaitAdvance();
        }
    }
}
