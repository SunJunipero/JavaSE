package readwritelock;

import java.util.Random;

public class Reader extends Thread {
    private ReadWriterList<Integer> list;

    public Reader(ReadWriterList list) {
        this.list = list;
    }

    @Override
    public void run() {
        Random random = new Random();
        int index = random.nextInt(list.size());
        int getValue = list.get(index);
        try {
            sleep(500);
            System.out.println(" reader " + getName() + " get " + getValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
