package JMM.deadlock.QueueExample;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class DeadLockDemo {
    static void transfer(Queue<String> in, Queue<String> out){
        synchronized (in){
            synchronized (out){
                String temp = in.poll();
                if (temp != null) {
                    out.add(temp);
                }
                else
                    System.out.println("try later");
            }
            System.out.println("in - " + in);
            System.out.println("out - " + out);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Queue<String> queueIn = new ArrayDeque<>(Arrays.asList("foo", "bar", "buz"));
        Queue<String> queueOut = new ArrayDeque<>(Arrays.asList("kek", "lol", "mm"));

        Thread thread1 = new Thread(()->{
            for (int i = 0; i < 1_00; i++) {
                System.out.println("Thread1 = " + i);
                transfer(queueIn, queueOut);
            }
        });

        Thread thread2 = new Thread(()->{
            for (int i = 0; i < 1_00; i++) {
                System.out.println("Thread2 = " + i);
                transfer(queueOut, queueIn);
            }
        });

        thread1.start(); thread2.start();
        thread1.join(); thread2.join();


    }
}
