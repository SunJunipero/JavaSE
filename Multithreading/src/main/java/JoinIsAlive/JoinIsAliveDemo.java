package JoinIsAlive;

public class JoinIsAliveDemo {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread("thread1");
        MyThread thread2 = new MyThread("thread2");
        MyThread thread3 = new MyThread("thread3");

        System.out.println("Priority - " + thread1.thread.getPriority());
        System.out.println("Priority - " + thread2.thread.getPriority());
        System.out.println("Priority - " + thread3.thread.getPriority());


        System.out.println("Check thread isAlive");
        System.out.println("thread1 is alive -" + thread1.thread.isAlive());
        System.out.println("thread2 is alive -" + thread2.thread.isAlive());
        System.out.println("thread3 is alive -" + thread3.thread.isAlive());

        try {
            thread1.thread.join();
            thread2.thread.join();
            thread3.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Check thread isAlive");
        System.out.println("thread1 is alive -" + thread1.thread.isAlive());
        System.out.println("thread2 is alive -" + thread2.thread.isAlive());
        System.out.println("thread3 is alive -" + thread3.thread.isAlive());
    }
}

