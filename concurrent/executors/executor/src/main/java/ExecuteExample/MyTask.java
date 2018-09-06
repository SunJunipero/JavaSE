package ExecuteExample;

import java.util.concurrent.Executor;

public class MyTask implements Executor {

    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
    }
}
