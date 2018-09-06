package futureExample;

import java.util.concurrent.Callable;
import java.util.stream.IntStream;

public class CallableFactorial implements Callable<Integer> {
    private int val;

    public CallableFactorial(int val) {
        this.val = val;
    }

    @Override
    public Integer call() throws Exception {
       return IntStream.rangeClosed(1, val)
                .boxed()
                .reduce((integer, integer2) -> integer * integer2)
                .get();
    }
}
