package AtomicReference.correct;

public class MyThread extends Thread {
    AtomicPoint point;

    public MyThread(AtomicPoint point) {
        this.point = point;
    }

    @Override
    public void run() {
        point.clockWise();
    }
}
