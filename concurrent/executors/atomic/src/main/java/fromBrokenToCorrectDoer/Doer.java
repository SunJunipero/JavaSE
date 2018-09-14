package fromBrokenToCorrectDoer;

public class Doer {
    private volatile boolean flag = false;

    public void doOnce (Runnable action){
        if(! flag){
            flag = true;
            action.run();
        }
    }
}
