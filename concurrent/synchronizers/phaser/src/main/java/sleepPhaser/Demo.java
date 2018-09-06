package sleepPhaser;

import java.util.concurrent.Executor;
import java.util.concurrent.Phaser;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser();
        phaser.register();

        System.out.println("Current phase - " + phaser.getPhase());
        System.out.println("Registered Parties - " + phaser.getRegisteredParties());

        new MyThread(phaser, 1000);
        new MyThread(phaser, 2000);
        new MyThread(phaser, 3000);

        //phaser.arriveAndDeregister();
        phaser.arriveAndAwaitAdvance();

        Thread.sleep(5000);
        System.out.println("Current phase - " + phaser.getPhase());
        System.out.println("Registered Parties - " + phaser.getRegisteredParties());


        //phaser.arriveAndDeregister();
        phaser.arriveAndAwaitAdvance();

        Thread.sleep(5000);
        System.out.println("Current phase - " + phaser.getPhase());
        System.out.println("Registered Parties - " + phaser.getRegisteredParties());

        Executor
    }
}
