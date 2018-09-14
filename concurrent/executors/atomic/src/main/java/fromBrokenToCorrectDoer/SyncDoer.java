package fromBrokenToCorrectDoer;

public class SyncDoer {
    private volatile boolean flag = false;

    public void doOnce(Runnable action){
        if (! flag){
            synchronized (this) {
                if(! flag){
                    flag = true;
                    action.run();
                }
            }
        }
    }
}
