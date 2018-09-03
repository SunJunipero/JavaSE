package Synchronized.list.nonStaticList;

import java.util.LinkedList;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws InterruptedException {

        Container container = new Container();
        Runnable thread = ()->{
            for (int i = 0; i < 100_000; i++) {
                container.addValye("lol");
            }
        };

        List<Thread> threads = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(thread);
            thread1.start();
            threads.add(thread1);
        }

        for (Thread thread1 : threads) {
            thread1.join();
        }
         while (container.size() < 1_000_000){}

        System.out.println("FINISHED");
    }
}
