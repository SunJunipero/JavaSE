package SharedLock;

import java.util.concurrent.locks.ReentrantLock;

public class Demo {

    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
        MyThread myThread = new MyThread(resource);
        MyThread myThread1 = new MyThread(resource);

        myThread.start();
        myThread1.start();

        myThread.join();
        myThread1.join();


        System.out.println(" i = " + resource.i + "  j = " + resource.j );

    }

    static class MyThread extends Thread {
        Resource resource;

        public MyThread(Resource resource) {
            this.resource = resource;
        }

        @Override
        public void run() {
            resource.changeI();
            resource.changeJ();
        }
    }

}
 class Resource{
    int i;
    int j;
    ReentrantLock lock = new ReentrantLock();

    void changeI (){
        System.out.println(Thread.currentThread().getName());
          lock.lock();
        for (int k = 0; k < 50_000; k++) {
            int t = this.i;
            t++;
            this.i = t;
        }
    }

    void changeJ (){
        for (int k = 0; k < 50_000; k++) {
            int t = this.j;
            t++;
            this.j = t;
        }
           lock.unlock();
    }

}
