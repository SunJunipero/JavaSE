package JMM.singleton.Lazy;

import java.util.stream.IntStream;

public class MyThread extends Thread {

    private Integer hCode;

    public Integer gethCode() {
        return hCode;
    }

    @Override
    public void run() {
        hCode = LazyContainer.getContainer().hashCode();
        System.out.println("hash code - " + LazyContainer.getContainer().hashCode()
                + "\n\t\t thread's name -  " + Thread.currentThread().getName());
    }
}
