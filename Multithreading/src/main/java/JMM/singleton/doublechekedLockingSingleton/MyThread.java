package JMM.singleton.doublechekedLockingSingleton;

public class MyThread extends Thread{

    private int hCode;
    private int val;

    public int gethCode() {
        return hCode;
    }

    public int getVal() {
        return val;
    }

    @Override
    public void run() {
        hCode = Container.getContainer().hashCode();
        val = Container.getContainer().x;
    }
}
