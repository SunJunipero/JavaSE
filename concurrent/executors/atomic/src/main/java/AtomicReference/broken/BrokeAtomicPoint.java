package AtomicReference.broken;

import java.util.concurrent.atomic.AtomicInteger;

public class BrokeAtomicPoint {
    private final AtomicInteger x = new AtomicInteger(0);
    private final AtomicInteger y = new AtomicInteger(1);

    public void lockWise(){
        int oldx = x.getAndSet(y.get());
        y.set(-oldx);
        System.out.println(toString());;
    }

    @Override
    public String toString() {
        return  "x=" + x +" y=" + y;
    }
}
