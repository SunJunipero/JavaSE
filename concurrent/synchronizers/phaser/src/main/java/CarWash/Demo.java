package CarWash;

import java.util.concurrent.Phaser;

public class Demo {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);

        CarWasher washer1 = new CarWasher("washer1", phaser);
        CarWasher washer2 = new CarWasher("washer2", phaser);
        CarWasher washer3 = new CarWasher("washer3", phaser);
    }
}
