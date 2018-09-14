package AtomicReference.broken;

public class MyThread extends Thread {
    BrokeAtomicPoint point;

    public MyThread(BrokeAtomicPoint point) {
        this.point = point;
    }

    @Override
    public void run() {
        point.lockWise();
    }
}
