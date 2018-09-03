/**
 Thread Adder waits semaphore
 Thread Adder acquire semaphore
 Adder : shared value - 1
 Adder : shared value - 2
 Adder : shared value - 3
 Adder : shared value - 4
 Adder : shared value - 5
 Thread Subtractor waits semaphore
 Thread Adder release semaphore
 Thread Subtractor acquire semaphore
 Subtractor : shared value - 5
 Subtractor : shared value - 4
 Subtractor : shared value - 3
 Subtractor : shared value - 2
 Subtractor : shared value - 1
 Thread Subtractor release semaphore
 */

package SimplSemaphoreDemo;

import java.util.concurrent.Semaphore;

public class Demo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(0);
        Adder adder = new Adder("Adder", semaphore);
        Subtractor subtractor = new Subtractor("Subtractor", semaphore);

    }
}
