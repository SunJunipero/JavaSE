package readwritelock;

import java.util.Random;

public class Writer extends Thread {
    private ReadWriterList<Integer> list;

    public Writer(ReadWriterList list) {
        this.list = list;
    }

    @Override
    public void run() {
        Random random = new Random();
        int val = random.nextInt(100);
        list.add(val);
        try {
            sleep(500);
            System.out.println(" writer " + getName() + " add " + val);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
