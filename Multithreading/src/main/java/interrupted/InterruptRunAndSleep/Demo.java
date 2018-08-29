package interrupted.InterruptRunAndSleep;



public class Demo {
    public static void main(String[] args) {
        Worker worker = new Worker();
        Sleeper sleeper = new Sleeper();

        /**
         * Если закомментировать 35-44 строки, и выставить
         *  worker.setDaemon(true);
         *  sleeper.setDaemon(true);
         * то JVM прибъет этих демнов, как только выполнится
         * главный поток. Если не устанавливать их как демонов,
         * то JVM будет какое-то время работать после выполнения
         * главного потока
         */

        worker.setDaemon(true);
        sleeper.setDaemon(true);

        System.out.println("\t\tstart");

        worker.start();
        sleeper.start();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("interrupt thread");
//        worker.interrupt();
//        sleeper.interrupt();
//
//        System.out.println("\t\tjoin thread");
//        try {
//            worker.join();
//            sleeper.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("All done");



    }
}
