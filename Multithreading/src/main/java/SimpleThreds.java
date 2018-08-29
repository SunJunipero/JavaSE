public class SimpleThreds {

    public static void printMessage(String msg) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " : " + msg);
    }

    static class myThread implements Runnable {
        @Override
        public void run() {
            String importantInfo[] = {
                    "Mares eat oats",
                    "Does eat oats",
                    "Little lambs eat ivy",
                    "A kid will eat ivy too"
            };

            try {
                for (int i = 0; i < importantInfo.length; i++) {
                    Thread.sleep(2000);
                    printMessage(importantInfo[i]);
                }
            }
            catch (InterruptedException e){
                printMessage("I wasn't done");
            }

        }
    }

    public static void main(String args[]) throws InterruptedException {

        printMessage("Starting MessageLoop thread");
        Thread t = new Thread(new myThread());


        StackTraceElement[] stackTrace = t.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            System.out.println(" ClassName - " + stackTraceElement.getClassName() +
                                " Method name -" + stackTraceElement.getMethodName());
        }

        t.start();

        printMessage("Waiting for MessageLoop thread to finish");
        // loop until MessageLoop
        // thread exits
        while (t.isAlive()) {
            printMessage("Still waiting...");
            // Wait maximum of 1 second
            // for MessageLoop thread
            // to finish.
            t.join(1000);

        }
        printMessage("Finally!");
    }
}
