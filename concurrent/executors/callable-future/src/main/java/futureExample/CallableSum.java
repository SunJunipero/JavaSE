package futureExample;

import java.util.concurrent.Callable;

public class CallableSum implements Callable<Integer> {
    private int x;
    private int y;

    public CallableSum(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Integer call() throws Exception {
        return x + y;
    }
}
