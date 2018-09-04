package SimplePhaserDemo;

import java.util.concurrent.Phaser;

public class Demo {
    public static void main(String[] args) {

        Phaser phaser = new Phaser(3);

        MyThread thread1 = new MyThread(phaser, "thread1");
        MyThread thread2 = new MyThread(phaser, "thread2");
        MyThread thread3 = new MyThread(phaser, "thread3");

        System.out.println("all threads await " + phaser.getPhase() + " phase");
        phaser.arriveAndAwaitAdvance();
        System.out.println(phaser.getPhase() + " phase is finished" );

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("all threads await " + phaser.getPhase() + " phase");
        phaser.arriveAndAwaitAdvance();
        System.out.println(phaser.getPhase() + " phase is finished" );

        phaser.arriveAndDeregister();

        if(phaser.isTerminated())
            System.out.println("FINISHED");
    }
}
