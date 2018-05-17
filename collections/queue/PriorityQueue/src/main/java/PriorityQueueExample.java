import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        Queue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.add("Miles");
        priorityQueue.add("Serge");
        priorityQueue.add("Math");
        priorityQueue.add("Alex");
        /**
         * don't allow add nul and non-comparable object
         */

        //NPE
        //priorityQueue.add(null);

        /*
        output:
        [Alex, Math, Miles, Serge]
         */
        System.out.println(priorityQueue);

        priorityQueue.remove("Math");
        System.out.println(priorityQueue.size());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.size());
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.size());
        System.out.println(priorityQueue.contains("Math"));
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.size());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.size());

    }
}
