/**
 * producer waits prodSemaphore
 * producer acquire prodSemaphore
 * send -  0
 * producer release suppSemaphore
 * producer waits prodSemaphore
 * supplier waits suppSemaphore
 * supplier acquire suppSemaphore
 * value n = 0
 * supplier release prodSemaphore
 * supplier waits suppSemaphore
 * producer acquire prodSemaphore
 * send -  1
 * producer release suppSemaphore
 * producer waits prodSemaphore
 * supplier acquire suppSemaphore
 * value n = 1
 * supplier release prodSemaphore
 * supplier waits suppSemaphore
 * producer acquire prodSemaphore
 * send -  2
 * producer release suppSemaphore
 * producer waits prodSemaphore
 * supplier acquire suppSemaphore
 * value n = 2
 * supplier release prodSemaphore
 * supplier waits suppSemaphore
 * producer acquire prodSemaphore
 * send -  3
 * producer release suppSemaphore
 * producer waits prodSemaphore
 * supplier acquire suppSemaphore
 * value n = 3
 * supplier release prodSemaphore
 * supplier waits suppSemaphore
 * producer acquire prodSemaphore
 * send -  4
 * producer release suppSemaphore
 * supplier acquire suppSemaphore
 * value n = 4
 * supplier release prodSemaphore
 */
package ProducseSupplierSemaphore;

public class Demo {
    public static void main(String[] args) {
        Q q = new Q();

        Producer producer = new Producer(q);
        Supplier supplier = new Supplier(q);


    }
}
