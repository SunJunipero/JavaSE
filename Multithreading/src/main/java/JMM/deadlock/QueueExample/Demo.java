package JMM.deadlock.QueueExample;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Demo{
    static void transfer(Queue<String> in, Queue<String> out){
        String temp = in.poll();
        if (temp != null) {
            out.add(temp);
        }
        System.out.println("in - " + in);
        System.out.println("out - " + out);
    }
    public static void main(String[] args) {
        Queue<String> queueIn = new ArrayDeque<>(Arrays.asList("foo", "bar", "buz"));
        Queue<String> queueOut = new ArrayDeque<>(Arrays.asList("kek", "lol", "mm"));

        System.out.println("\t\t----"+ " INIT " + "----");
        System.out.println(queueIn);
        System.out.println(queueOut);

        for (int i = 0; i < 20; i++) {
            System.out.println("\t\t----"+ i +"----");
            transfer(queueIn, queueOut);
            transfer(queueOut, queueIn);
        }
    }
}
