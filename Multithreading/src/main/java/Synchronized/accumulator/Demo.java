package Synchronized.accumulator;

public class Demo {
    public static void main(String[] args) {
        Resource resource = new Resource(5);
        Client alex = new Client(resource, "Alex");
        Client miles = new Client(resource, "Miles");

        Thread thread1 = new Thread(alex);
        Thread thread2 = new Thread(miles);

        thread1.setName("one");

        thread1.start();
        thread2.start();

        /**
         * Maybe Expected output
         * thread1
             * int i = this.i;  i = 5
           thread2
         *     int i = this.i;  i = 5
         *     i++; i = 6
         *     this.i = i; i = 6
            thread1
               i++; i = 6
               this.i = i; i = 6
         *
         */

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(resource.getI());
        System.out.println(alex.resource.getI());
        System.out.println(miles.resource.getI());


    }
}
