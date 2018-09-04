package SimplePhaserDemo;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.Phaser;

public class MyThread extends Thread {
    private Phaser phaser;
    private String name;

    public MyThread(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        start();
     //   phaser.register();
    }

    @Override
    public void run() {
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " start 1 phase");
        phaser.arriveAndAwaitAdvance();
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(name + " :  phase - " + phaser.getPhase() + " : " + i );
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + " start 2 phase");
        phaser.arriveAndAwaitAdvance();

        for (int i = 0; i < 5; i++) {
            System.out.println(name + " :  phase - " + phaser.getPhase() + " : " + i );
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        phaser.arriveAndDeregister();


    }
}
