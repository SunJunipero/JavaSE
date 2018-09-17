package ThreadFactory;

import java.util.concurrent.ThreadFactory;

public class MyFactory implements ThreadFactory {
    int count;
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, "custom thread - " + count++);
        thread.setPriority(Thread.MAX_PRIORITY);
        return thread;
    }
}
