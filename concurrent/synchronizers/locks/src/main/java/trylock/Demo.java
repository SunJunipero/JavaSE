package trylock;

import java.util.concurrent.locks.ReentrantLock;

public class Demo {
    static ReentrantLock locker = new ReentrantLock();

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();

    }

    static class Thread1 extends Thread{
        @Override
        public void run() {
            locker.lock();
            try {
                System.out.println(getName() + " working ");
                sleep(50);
            }
            catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
            finally {
                System.out.println("\t\t" + getName() + " release lock ");
                locker.unlock();
            }
        }
    }

    static class Thread2 extends Thread{
        @Override
        public void run() {
            while (true){
                if(locker.tryLock()){
                    System.out.println(" \t\t" + getName() + "working");
                    break;
                }
                System.out.println(getName() + "waiting");
            }

        }
    }
}
