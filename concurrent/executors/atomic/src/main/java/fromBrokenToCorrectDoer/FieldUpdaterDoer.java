package fromBrokenToCorrectDoer;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class FieldUpdaterDoer {
    private volatile int flag = 0;
    private static final AtomicIntegerFieldUpdater<FieldUpdaterDoer> FLAG =
            AtomicIntegerFieldUpdater.newUpdater(FieldUpdaterDoer.class, "flag");

    public void doOnce(Runnable action){
        if (FLAG.compareAndSet(this, 0, 1)){
            action.run();
        }
    }
}
