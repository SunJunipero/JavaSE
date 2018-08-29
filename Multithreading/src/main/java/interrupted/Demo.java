package interrupted;

public class Demo implements Runnable{
        public void run() {
            try {
                System.out.println("in run() - about to work2()");
                work2();
                System.out.println("in run() - back from work2()");
            } catch (InterruptedException x) {
                System.out.println("in run() - interrupted in work2()");
                return;
            }
            System.out.println("in run() - doing stuff after nap");
            System.out.println("in run() - leaving normally");
        }
        public void work2() throws InterruptedException {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("C isInterrupted()="+ Thread.currentThread().isInterrupted());
                    Thread.sleep(2000);
                    System.out.println("D isInterrupted()="+ Thread.currentThread().isInterrupted());
                }
            }
        }

        public static void main(String[] args) {
            Demo si = new Demo();
            Thread t = new Thread(si);
            t.start();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException x) { }

            System.out.println("in main() - interrupting other thread");
            t.interrupt();
            System.out.println("in main() - leaving");
        }
    }
