package sleepPhaser;

import java.util.concurrent.Phaser;

public class MyThread extends Thread{
    Phaser phaser;
    int dream;

    public MyThread(Phaser phaser, int dream) {
        this.phaser = phaser;
        phaser.register();
        this.dream = dream;
        start();
    }

    @Override
    public void run() {
        System.out.println(getName() + "is arrived");
        phaser.arriveAndAwaitAdvance();
        try {
            sleep(dream);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " after passing barrier");
       // phaser.arriveAndDeregister();
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + "is arrived");
        phaser.arriveAndAwaitAdvance();
        try {
            sleep(dream);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " after passing barrier");


    }
}
